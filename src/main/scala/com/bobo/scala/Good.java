package com.bobo.scala;

/**
 * Created by bobo on 2017/6/30.
 */
public class Good {
    public static void main(String[] args) {
        print(1, 5);
    }

    static void print(int x, int n) {
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
