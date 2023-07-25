package สตั้5;
import java.math.BigDecimal;

public class five {
    public static void main(String[] args) {
        for (int i = 100; i <= 1000; i += 100) {
            BigDecimal sum = BigDecimal.ZERO;
            for (int j = 0; j <= i; j++) {
                BigDecimal term = BigDecimal.ONE.divide(factorial(j), 25, BigDecimal.ROUND_HALF_UP);
                sum = sum.add(term);
            }
            System.out.printf("e for i = %d: %s\n", i, sum);
        }
    }

    public static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
