package com.grasshopper.exchange.order;

import java.util.HashMap;
import java.util.Map;


public class OrderHolder {
    public Map<Long, Order> getOrderMap() {
        return orderMap;
    }

    private Map<Long, Order> orderMap;

    //Key is orderID
    public OrderHolder(Order order) {
        this.orderMap = new HashMap<>();
        orderMap.put(order.getOrderId(), order);
    }

    public double getPricelevel() {
        return orderMap.values().stream().findFirst().map(e -> e.getPrice()).get();
    }

    public long getCumulativeQty() {
        return orderMap.values().stream().map(order -> order.getSize()).mapToLong(Long::longValue).sum();
    }

}
