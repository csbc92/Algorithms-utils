package dk.sdu.mmmi.algo.utils;

public class Potens {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            TOPOTENS(i);
        }

        System.out.println("Udtrykket er sandt..");

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
}
