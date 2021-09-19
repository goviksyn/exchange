package com.grasshopper.exchange.event;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class EventParser {

    public Event parse(String event)  {
        String[] eventArray = event.split(",");
        Event eventObj = new Event();
        eventObj.setSeq_num(getLong(eventArray[0]));
        eventObj.setAdd_order_id(getLong(eventArray[1]));
        eventObj.setAdd_side(eventArray[2]);

        eventObj.setAdd_price(getDouble(eventArray[3]));
        eventObj.setAdd_qty(getLong(eventArray[4]));
        eventObj.setUpdate_order_id(getLong(eventArray[5]));
        eventObj.setUpdate_side(eventArray[6]);

        eventObj.setUpdate_price(getDouble(eventArray[7]));
        eventObj.setUpdate_qty(getLong(eventArray[8]));
        eventObj.setDelete_order_id(getLong(eventArray[9]));
        eventObj.setDelete_side(eventArray[10]);

        eventObj.setTrade_order_id(getLong(eventArray[11]));
        eventObj.setTrade_side(eventArray[12]);
        eventObj.setTrade_price(getDouble(eventArray[13]));
        eventObj.setTrade_qty(getLong(eventArray[14]));
        eventObj.setTime(eventArray[15]);
        return eventObj;

    }

    private Long getLong(String val) {
        return val.isEmpty() ? 0l : Long.parseLong(val);
    }
    private Double getDouble(String val) {
        return val.isEmpty() ? 0.0 : Double.parseDouble(val);
    }


}
