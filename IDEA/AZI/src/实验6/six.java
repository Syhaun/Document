package ʵ��6;

import java.util.Scanner;

public class six {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GeometricObject[] a = new GeometricObject[4];
        System.out.println("����������Բ�İ뾶");
        Circle circle1 = new Circle(in.nextDouble());
        Circle circle2 = new Circle(in.nextDouble());
        System.out.println("�������������εĳ��Ϳ�");
        Rectangle rectangle1 = new Rectangle(in.nextDouble(), in.nextDouble());
        Rectangle rectangle2 = new Rectangle(in.nextDouble(), in.nextDouble());
        a[0] = circle1;
        a[1] = circle2;
        a[2] = rectangle1;
        a[3] = rectangle2;
        System.out.println("���е�Բ�κ;������֮��Ϊ��" + sumArea(a));
    }
    public static double sumArea(GeometricObject[] a) {
      double sum = 0.0;
        for (int i = 0; i < 4; i++) {
            if(i < 2){
                Circle circle = (Circle) a[i];
                sum += circle.getArea();
            }else {
                Rectangle rectangle = (Rectangle) a[i];
                sum += rectangle.getArea();
            }
        }
        return sum;
    }
}
class Rectangle extends GeometricObject {
    double a;
    double b;
    Rectangle(double a,double b) {
        this.a = a;
        this.b = b;
    }
    double getArea() {
        return a * b;
    }
}