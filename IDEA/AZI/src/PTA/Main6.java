package PTA;

import java.util.Scanner;

interface IShape {// 接口

    double getArea(); // 求面积

    double getPerimeter();// 求周长

}
/* 这里有正n边形类RegularPolygon的实现*/

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /* 你提交的代码将嵌入到这里 */

        int n = in.nextInt();double a = in.nextDouble();
        RegularPolygon c = new RegularPolygon(n,a);
        System.out.printf("%.4f\n", c.getArea());
        System.out.printf("%.4f\n", c.getPerimeter());
    }
}
