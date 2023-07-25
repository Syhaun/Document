package AZIY;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 301;
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextDouble();
        }

        int maxCount = 0;

        double maxStart = 0;


        for (double start = -300; start <= 0; start+=0.00002) {
            int count = 0;
            for(int i = 0; i < data.length;i++) {
                double end = start + 20;
                if(data[i] >= start && data[i] <= end)
                    count++;
            }
            if(count > maxCount) {
                maxCount = count;
                maxStart = start;
            }

        }
        System.out.println(maxCount);
        System.out.println(maxStart);

    }
}
