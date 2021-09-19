package com.grasshopper.exchange.order;

import com.grasshopper.exchange.publisher.BBOPublisher;
import com.grasshopper.exchange.common.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Scope("singleton")
public class OrderBook {

    @Autowired
    BBOPublisher BBOPublisher;

    String currentVal ="";
    HashMap<Long,Double> priceToId = new HashMap<>();
    HashMap<Long,Order> deleteOrderOutOfSync = new HashMap<>();
    HashMap<Long,Order> updateOrderOutOfSync = new HashMap<>();

    //Key is low for ask/sell
    private TreeMap<Double, OrderHolder> ask = new TreeMap<>();
    //key is high for buy/bid
    private TreeMap<Double, OrderHolder> bid = new TreeMap<>(Comparator.reverseOrder());

    private Optional<OrderHolder> getLatestBidPrice() {
        return bid.entrySet().stream().findFirst().map(ele -> ele.getValue());
    }

    private Optional<OrderHolder> getLatestAskPrice() {
        return ask.entrySet().stream().findFirst().map(ele -> ele.getValue());
    }

    public void add(Order order) {
        if (order.getSide().equals(Side.SELL)) {
            refreshBook(order,bid,ask);
        } else {
            refreshBook(order,ask,bid);
        }
        publishCurrentStatus(order.getSeqnumber(),order.getTime());
    }

    private void refreshBook(Order order,TreeMap<Double, OrderHolder> first,TreeMap<Double, OrderHolder> second) {
        long quantity = order.getSize();
        priceToId.put(order.getOrderId(),order.getPrice());
        //Check in bid
        if (first.containsKey(order.getPrice())) {
            OrderHolder orderHolder = first.get(order.getPrice());
            for (Map.Entry<Long, Order> entry : orderHolder.getOrderMap().entrySet()) {
                if(quantity <= entry.getValue().getSize()){
                    entry.getValue().setSize(entry.getValue().getSize() - quantity);
                    //Trade happen publish
                }else if(quantity > entry.getValue().getSize()){
                    //Trade happen publish, partially
                    quantity = quantity - entry.getValue().getSize();
                    orderHolder.getOrderMap().remove(entry.getKey());//remove the order id
                    order.setSize(quantity);
                }
            }
        }
        if(order.getSize() > 0){
            if(!second.containsKey(order.getPrice())){
                second.put(order.getPrice(),new OrderHolder(order));
            } else{
                OrderHolder orderHolder = second.get(order.getPrice());
                orderHolder.getOrderMap().put(order.getOrderId(), order);
            }
        }
    }

    public void update(Order order) {
        double price = priceToId.get(order.getOrderId());
        if (order.getSide().equals(Side.SELL)) {
            ask.get(price).getOrderMap().put(order.getOrderId(),order);
        } else {
            bid.get(price).getOrderMap().put(order.getOrderId(),order);
        }
        publishCurrentStatus(order.getSeqnumber(),order.getTime());
    }


    public void delete(Order order) {
        double price = priceToId.get(order.getOrderId());
        if (order.getSide().equals(Side.SELL)) {
            ask.get(price).getOrderMap().remove(order.getOrderId());
            if(ask.get(price).getOrderMap().size() == 0){
                ask.remove(price);
            }
        } else {
            bid.get(price).getOrderMap().remove(order.getOrderId());
            if(bid.get(price).getOrderMap().size() == 0){
                bid.remove(price);
            }
        }
        publishCurrentStatus(order.getSeqnumber(),order.getTime());
    }



    private void publishCurrentStatus(long seq_num, String time) {
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Optional<OrderHolder> bid = this.getLatestBidPrice();
        Optional<OrderHolder> ask = this.getLatestAskPrice();
        String datetime = time;
        if(bid.isPresent() && ask.isPresent()){
            String currentStatus =  datetime + "," + bid.get().getPricelevel() + "," + ask.get().getPricelevel() +"," + bid.get().getCumulativeQty() + ","+ask.get().getCumulativeQty() +
                    ","+seq_num;

            String latestStatus = bid.get().getPricelevel() + "," + ask.get().getPricelevel() +"," + bid.get().getCumulativeQty() + ","+ask.get().getCumulativeQty();
            if(!latestStatus.equalsIgnoreCase(currentVal))
                BBOPublisher.publish(currentStatus);
            currentVal = latestStatus;
        }
    }

}
