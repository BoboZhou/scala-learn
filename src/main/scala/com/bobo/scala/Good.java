package com.bobo.scala;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bobo on 2017/6/30.
 */
public class Good {
    public static void main(String[] args) {
        print(1, 5);
        Date date = new Date();
        int day = date.getDay();
        System.out.println(day);
    }

    static void print(int x, int n) {
        HashMap<Object, Object> map = new HashMap<>();

        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
        }
        if (x > n)
            return;
        for (int i = 0; i < n - x; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 2 * x - 1; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < n - x; i++) {
            System.out.print(" ");
        }
        System.out.println(" ");
        print(x + 1, n);
    }

}
