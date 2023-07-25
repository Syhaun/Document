package 实验6;

import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入两个圆的半径");
        Circle1 circle1 = new Circle1(in.nextDouble());
        Circle1 circle2 = new Circle1(in.nextDouble());
        System.out.println(circle1.equals(circle2));
    }
}
class Circle1 extends GeometricObject implements Comparable<Circle1>{
    double radius;
    Circle1(double radius) {
        this.radius = radius;
    }
    public int compareTo(Circle1 o) {
        if(this.radius == o.radius)
            return 0;
        else if (this.radius > o.radius) {
            return 1;
        }else
            return -1;
    }
    public boolean equals(Circle1 o) {
        return this.radius == o.radius;
    }
}