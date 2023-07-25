package AZIY;

import com.sun.source.tree.WhileLoopTree;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger m = in.nextBigInteger();
        int n = in.nextInt();
        int count = 0;
        if(m.isProbablePrime(100000)){
            System.out.println(m);
            count++;
        }
        while (count < n) {
            m = m.nextProbablePrime();
            System.out.println(m);
            count++;
        }
    }
}
