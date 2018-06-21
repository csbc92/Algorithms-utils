package dk.sdu.mmmi.algo.utils;

import java.util.Arrays;

public class Potens {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            GANGESYV(i);
//        }
//
//        System.out.println("Udtrykket er sandt..");

        for (int i = 1; i < 100; i++) {
            System.out.print(i + " ");
            System.out.println(algoritme1(i));
        }

    }

    public static int TOPOTENS(int n) {
        int x = n;
        int r = 1;

        if (!(x + r == n + 1)) {
            throw new RuntimeException("Udtrykket er falsk");
        }

        while (x > 0) {
            r = 2*r;
            x = x - 1;

            if (!((x + r == n + 1))) {
                throw new RuntimeException("Udtrykket er falsk");
            }
        }

        return r;
    }

    public static int GANGESYV(int n) {
        int x = n;
        int r = 0;

        if (!(r == 7*n)) {
            throw new RuntimeException("Udtrykket er falsk");
        }
        while (x > 0) {
            x = x - 1;
            r = r + 7;

            if (!(r == 7*n)) {
                throw new RuntimeException("Udtrykket er falsk");
            }
        }

        return r;
    }

    public static int algoritme1(int n) {
        int time = 0;

        int s = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    s = s + 1;
                    time++;
                }
            }

        }

        return time;
    }

    public static int algoritme2(int n) {
        int time = 0;
        int s = 0;

        while (n > 1) {
            for (int i = 1; i <= n; i++) {
                s = s +1;
                time++;
            }

            n = (int)(n/2);
        }


        return time;
    }

    public static int algoritme3(int n) {
        int time = 0;

        int i = 1;

        while (i < n) {
            i = i * n;
            time++;
        }

        return time;
    }

    public static int algoritme4(int n) {
        int time = 0;

        int i = 1;

        while (i < n) {
            int s = 0;
            while (s < n) {
                s = s + i;
                time++;
            }
            i = i * 2;
        }

        return time;
    }
}
