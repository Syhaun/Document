package ʵ��6;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("��ֱ���������Բ�εİ뾶");
        ComparableCircle circle1 = new ComparableCircle(in.nextDouble());
        ComparableCircle circle2 = new ComparableCircle(in.nextDouble());
        int result = circle1.compareTo(circle2);
        switch (result) {
            case 1:
                System.out.println("��һ��Բ������ȵڶ���Բ��");
            case 0:
                System.out.println("����Բһ����");
            case -1:
                System.out.println("��һ��Բ������ȵڶ���Բ��С");
        }
    }
}
class Circle extends GeometricObject{
    double radius;
	Circle() {

    }
    Circle(double radius)
    {
        this.radius = radius;
    }
    double getArea() {
        return radius * radius * Math.PI;
    }
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }
}
class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    ComparableCircle(double radius) {
        this.radius = radius;
    }
    public int compareTo(ComparableCircle o){
        if(this.getArea() < o.getArea())
            return -1;
        else if(this.getArea() > o.getArea())
            return 1;
        else
            return 0;
    }
}
