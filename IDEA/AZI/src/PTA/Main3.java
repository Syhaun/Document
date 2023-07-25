package PTA;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RegularPolygon poly1 = new RegularPolygon();
        System.out.printf("%.2f %.2f\n", poly1.getPerimeter(), poly1.getArea());
        int n = in.nextInt();
        double side = in.nextDouble();
        RegularPolygon poly2 = new RegularPolygon(n, side);
        System.out.printf("%.2f %.2f\n", poly2.getPerimeter(), poly2.getArea());
        n = in.nextInt();
        side = in.nextDouble();
        double x = in.nextDouble();
        double y = in.nextDouble();
        RegularPolygon poly3 = new RegularPolygon(n, side, x, y);
        System.out.printf("%.2f %.2f\n", poly3.getPerimeter(), poly3.getArea());
        in.close();
    }
}

/* 请在这里填写答案 */
class RegularPolygon {
    //TODO 编写代码
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;
    RegularPolygon(){
    }
    RegularPolygon(int n,double side){
        this.n = n;
        this.side = side;
    }
    RegularPolygon(int n,double side,double x,double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public double getSide() {
        return side;
    }

    public int getN() {
        return n;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    double getPerimeter(){
        return n*side;
    }
    double getArea(){
        return n*side*side/4/Math.tan(Math.PI/n);
    }
}
