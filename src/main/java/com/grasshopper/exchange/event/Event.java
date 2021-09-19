package com.grasshopper.exchange.event;


public class Event {
    long seq_num;
    long add_order_id;
    String add_side;
    double add_price;
    long add_qty;
    long update_order_id;
    String update_side;

    double update_price;
    long update_qty;
    long delete_order_id;
    String delete_side;

    long trade_order_id;
    String trade_side;
    long trade_qty;
    double trade_price;
    String time;

    public long getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(long seq_num) {
        this.seq_num = seq_num;
    }

    public long getAdd_order_id() {
        return add_order_id;
    }

    public void setAdd_order_id(long add_order_id) {
        this.add_order_id = add_order_id;
    }

    public String getAdd_side() {
        return add_side;
    }

    public void setAdd_side(String add_side) {
        this.add_side = add_side;
    }

    public double getAdd_price() {
        return add_price;
    }

    public void setAdd_price(double add_price) {
        this.add_price = add_price;
    }

    public long getAdd_qty() {
        return add_qty;
    }

    public void setAdd_qty(long add_qty) {
        this.add_qty = add_qty;
    }

    public long getUpdate_order_id() {
        return update_order_id;
    }

    public void setUpdate_order_id(long update_order_id) {
        this.update_order_id = update_order_id;
    }

    public String getUpdate_side() {
        return update_side;
    }

    public void setUpdate_side(String update_side) {
        this.update_side = update_side;
    }

    public double getUpdate_price() {
        return update_price;
    }

    public void setUpdate_price(double update_price) {
        this.update_price = update_price;
    }

    public long getUpdate_qty() {
        return update_qty;
    }

    public void setUpdate_qty(long update_qty) {
        this.update_qty = update_qty;
    }

    public long getDelete_order_id() {
        return delete_order_id;
    }

    public void setDelete_order_id(long delete_order_id) {
        this.delete_order_id = delete_order_id;
    }

    public String getDelete_side() {
        return delete_side;
    }

    public void setDelete_side(String delete_side) {
        this.delete_side = delete_side;
    }

    public long getTrade_order_id() {
        return trade_order_id;
    }

    public void setTrade_order_id(long trade_order_id) {
        this.trade_order_id = trade_order_id;
    }

    public String getTrade_side() {
        return trade_side;
    }

    public void setTrade_side(String trade_side) {
        this.trade_side = trade_side;
    }

    public long getTrade_qty() {
        return trade_qty;
    }

    public void setTrade_qty(long trade_qty) {
        this.trade_qty = trade_qty;
    }

    public double getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(double trade_price) {
        this.trade_price = trade_price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "seq_num=" + seq_num +
                ", add_order_id=" + add_order_id +
                ", add_side='" + add_side + '\'' +
                ", add_price=" + add_price +
                ", add_qty=" + add_qty +
                ", update_order_id=" + update_order_id +
                ", update_side='" + update_side + '\'' +
                ", update_price=" + update_price +
                ", update_qty=" + update_qty +
                ", delete_order_id=" + delete_order_id +
                ", delete_side='" + delete_side + '\'' +
                ", trade_order_id=" + trade_order_id +
                ", trade_side='" + trade_side + '\'' +
                ", trade_qty=" + trade_qty +
                ", trade_price=" + trade_price +
                ", time=" + time +
                '}';
    }
}
