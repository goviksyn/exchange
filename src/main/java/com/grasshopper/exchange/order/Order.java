package com.grasshopper.exchange.order;

import com.grasshopper.exchange.common.Side;

import java.util.Date;

public class Order {
    private long orderId;
    private Side side;
    private double price;
    private long size;
    private String time;
    private long seqnumber;

    public Order(long orderId, Side side, double price, long size, String time, long seqnumber) {
        this.orderId = orderId;
        this.side = side;
        this.price = price;
        this.size = size;
        this.time = time;
        this.seqnumber = seqnumber;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getSeqnumber() {
        return seqnumber;
    }

    public void setSeqnumber(long seqnumber) {
        this.seqnumber = seqnumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", side=" + side +
                ", price=" + price +
                ", size=" + size +
                ", time=" + time +
                ", seqnumber=" + seqnumber +
                '}';
    }
}
