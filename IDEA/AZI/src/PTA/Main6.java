package PTA;

import java.util.Scanner;

interface IShape {// �ӿ�

    double getArea(); // �����

    double getPerimeter();// ���ܳ�

}
/* ��������n������RegularPolygon��ʵ��*/

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /* ���ύ�Ĵ��뽫Ƕ�뵽���� */

        int n = in.nextInt();double a = in.nextDouble();
        RegularPolygon c = new RegularPolygon(n,a);
        System.out.printf("%.4f\n", c.getArea());
        System.out.printf("%.4f\n", c.getPerimeter());
    }
}
