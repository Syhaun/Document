package สตั้5;
import java.math.BigInteger;

public class four {
    public static void main(String[] args) {
        final BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger current = maxLong.add(BigInteger.ONE);
        int count = 0;
        while(count < 5) {
            if (current.isProbablePrime(100))
            { System.out.println(current);
                count++;
            }
            current = current.add(BigInteger.ONE);
            }
        }
    }

