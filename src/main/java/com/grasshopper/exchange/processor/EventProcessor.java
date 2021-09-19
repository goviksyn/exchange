package com.grasshopper.exchange.processor;

import com.grasshopper.exchange.common.Side;
import com.grasshopper.exchange.event.Event;
import com.grasshopper.exchange.order.Order;
import com.grasshopper.exchange.order.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {

    @Autowired
    OrderBook orderBook;

    public void processEvent(Event event){
       createOrderFromEvent(event);
    }

    private void createOrderFromEvent(Event event){
        if(event.getAdd_order_id() > 1){
            Order order = new Order(event.getAdd_order_id(), Side.valueOf(event.getAdd_side()),event.getAdd_price(),event.getAdd_qty(),event.getTime(),event.getSeq_num());
            orderBook.add(order);
        }else if(event.getUpdate_order_id() >1){
            Order order = new Order(event.getUpdate_order_id(), Side.valueOf(event.getUpdate_side()),event.getUpdate_price(),event.getUpdate_qty(),event.getTime(),event.getSeq_num());
            orderBook.update(order);
        }else if(event.getDelete_order_id() > 1){
            Order order = new Order(event.getDelete_order_id(), Side.valueOf(event.getDelete_side()),0.0,0l,event.getTime(),event.getSeq_num());
            orderBook.delete(order);
        }else if(event.getTrade_order_id() >1){
            Order tmp = new Order(event.getTrade_order_id(), Side.valueOf(event.getTrade_side()),event.getTrade_price(),event.getTrade_qty(),event.getTime(),event.getSeq_num());
            //Do nothing..
        }else{
            System.out.println("Unknow event, ignoring...");
        }
    }


}
