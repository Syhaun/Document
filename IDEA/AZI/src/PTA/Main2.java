package PTA;

import java.util.Scanner;

public class Main2 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("numberOfObjects=" + StudentOf2019EE.getNumberOfObjects() + ",clazzMoney=" + StudentOf2019EE.getClazzMoney());

        StudentOf2019EE a = new StudentOf2019EE("Tom");
        StudentOf2019EE b = new StudentOf2019EE("Jerry", 200);
        StudentOf2019EE c = a;

        a.payClazzMoney(input.nextInt());
        System.out.println("numberOfObjects=" + StudentOf2019EE.getNumberOfObjects() + ",clazzMoney=" + StudentOf2019EE.getClazzMoney());

        b.payClazzMoney(input.nextInt());
        System.out.println("numberOfObjects=" + StudentOf2019EE.getNumberOfObjects() + ",clazzMoney=" + StudentOf2019EE.getClazzMoney());

        c.payClazzMoney(input.nextInt());
        System.out.println("numberOfObjects=" + StudentOf2019EE.getNumberOfObjects() + ",clazzMoney=" + StudentOf2019EE.getClazzMoney());

        StudentOf2019EE.clazzActivity(input.nextInt());
        System.out.println("numberOfObjects=" + StudentOf2019EE.getNumberOfObjects() + ",clazzMoney=" + StudentOf2019EE.getClazzMoney());
    }
}

/* 请在这里填写答案 */
class StudentOf2019EE{
    private String name;
    private int money;
    private static int numberOfObjects = 0;
    private static int clazzMoney = 0;
    StudentOf2019EE(String name){
        this.name = name;
        money = 100;
        numberOfObjects++;
    }
    StudentOf2019EE(String name,int money){
        this.name = name;
        this.money = money;
        numberOfObjects++;
    }

    public String getName() {
        return name;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public static int getClazzMoney() {
        return clazzMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void payClazzMoney(int amount){
        if(this.money<amount) {
            clazzMoney += this.money;
            this.money = 0;
        }            else {
            clazzMoney += amount;
            this.money-=amount;
        }

    }
    public static void clazzActivity(int amount){
        if(clazzMoney<amount)
            clazzMoney = 0;
        else
            clazzMoney -= amount;

    }
}
