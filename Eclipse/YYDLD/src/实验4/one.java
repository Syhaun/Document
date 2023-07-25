package สตั้4;

import java.util.Date;

public class one {
    public static void main(String[] args) {
        long[] times = {
                10000L, 100000L, 10000000L, 100000000L,
                1000000000L, 10000000000L, 100000000000L
        };

        for (long time : times) {
            Date date = new Date();
            date.setTime(time);
            System.out.println(date.toString());
        }
    }
}
