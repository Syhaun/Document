package ʵ��2;
import java.util.Date;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        System.out.println("������id:");
        int id= scanf.nextInt();
        System.out.println("�������˻����:");
        double balance= scanf.nextDouble();
        Account account1=new Account(id,balance);
        account1.setAnnualInterestRate(4.5);
        System.out.println("���������ȡ����:");
        double withDrew= scanf.nextDouble();
        account1.withDraw(withDrew);
        System.out.println("��������Ĵ����:");
        double deposit= scanf.nextDouble();
        account1.deposit(deposit);
        System.out.println("��"+account1.getbalance()+"����Ϣ��"+account1.getMonthlyInterest()+"���ڣ�"+account1.getDateCreated().toString());
    }
}
class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    public Account() {

    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public double getbalance() {
        return balance;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (this.annualInterestRate / 12) / 100;
    }

    public double getMonthlyInterest() {
        double MonthlyInterest = this.balance * this.getMonthlyInterestRate();
        return MonthlyInterest;
    }

    public void withDraw(double withdraw) {
        this.balance -= withdraw;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
    }
}
