package 实验6;

import java.util.Date;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println("请分别输入三角形的三条边");
        triangle.side1 = in.nextDouble();
        triangle.side2 = in.nextDouble();
        triangle.side3 = in.nextDouble();
        System.out.println("请输入该三角形的颜色以及是否填充");

        triangle.setColor(in.next());
        triangle.setFilled(in.nextBoolean());
        double area = triangle.getArea();
        double l = triangle.getPerimeter();

        System.out.println(" 三条边分别是：" + triangle.side1 + " " + triangle.side2 + " " + triangle.side3);
        System.out.println(" 面积：" + triangle.getArea());
        System.out.println(" 周长：" + triangle.getPerimeter());
        System.out.println(" 颜色：" + triangle.getColor());
        System.out.println(" 是否填充：" + triangle.isFilled());
        System.out.println(" 日期：" + triangle.getDateCreated());
    }
}
class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    public GeometricObject() {
        dateCreated = new Date();
    }
    public GeometricObject(String color,boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public String toString() {
        return "created on" + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}
class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;
    public Triangle() {

    }
    public Triangle(double side1,double side2,double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double Area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return Area;
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
       return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
