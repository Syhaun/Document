package AZIY;

import java.math.BigInteger;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        BigInteger  c = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        BigInteger a = c.divide(b);
        System.out.println(a);
    }
}
