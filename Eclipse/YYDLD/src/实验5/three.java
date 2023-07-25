package สตั้5;

import java.math.BigInteger;

public class three {
    public static void main(String[] args) {
        final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger num = MAX_LONG.subtract(MAX_LONG.mod(BigInteger.valueOf(30))).add(BigInteger.valueOf(30)); // find first number greater than MAX_LONG that is divisible by 30
        
        int count = 0;
        while (count < 10) {
            if (num.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO)) {
                System.out.println(num);
                count++;
            }
            num = num.add(BigInteger.valueOf(30)); // increment by 30 to find the next number divisible by 5 or 6
        }
    }
}

