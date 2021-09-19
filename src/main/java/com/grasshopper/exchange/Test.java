package com.grasshopper.exchange;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        //TreeMap<Long,String> treeMap = new TreeMap(Comparator.reverseOrder());
        TreeMap<Long,String> treeMap = new TreeMap();
        //add key value pairs to TreeMap
        treeMap.put(22l,"One");
        treeMap.put(1l,"Two");
        treeMap.put(3l,"Three");

        System.out.println(treeMap);
        //{22=One, 3=Three, 1=Two}*/
        treeMap.entrySet().stream().findFirst().map(e -> e.getValue());
        System.out.println( treeMap.entrySet().stream().findFirst().map(e -> e.getValue()));
        LocalDateTime a = LocalDateTime.now();
        System.out.println(a);
     //2021-08-03 01:00:01.107502 UTC
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String sss = "2021-08-03 08:35:26.765 UTC";
        System.out.println(sss.length());
        Date parse = utcFormat.parse("2021-08-03 08:21:35.352");

        System.out.println(parse);


       /* Date dd = utcFormat.parse(time.replace(" UTC",""));

        System.out.println(utcFormat.format(dd));
        String t = "229.34";
        System.out.println(Double.valueOf(t));
        System.out.println(Long.valueOf(t));
*/




    }
}
//2021-08-03 01:00:01.107502 UTC
//2021-09-17T18:05:48.776