package PTA;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateStr1 = scanner.nextLine();
        String dateStr2 = scanner.nextLine();

        LocalDate date1 = LocalDate.parse(dateStr1);
        LocalDate date2 = LocalDate.parse(dateStr2);

        if (date1.isBefore(date2)) {
            System.out.println("第一个日期比第二个日期更早");
            System.out.println("两个日期间隔" + date1.until(date2, ChronoUnit.DAYS) + "天");
            System.out.println("两个日期间隔" + date1.until(date2, ChronoUnit.WEEKS) + "周");
        } else if (date1.isAfter(date2)) {
            System.out.println("第一个日期比第二个日期更晚");
            System.out.println("两个日期间隔" + date2.until(date1, ChronoUnit.DAYS) + "天");
            System.out.println("两个日期间隔" + date2.until(date1, ChronoUnit.WEEKS) + "周");
        }
    }
}
