package PTA;

import java.util.Scanner;
import java.text.DecimalFormat;

class shape {// ��״��

    public double getArea()// �����
    { return 0;  }
    public double getPerimeter()// ���ܳ�
    { return 0;  }
}
/* ���ύ�Ĵ��뽫��Ƕ�뵽���� */
class RHexagon extends shape{
    private double side;
    RHexagon(double side){
        this.side = side;
    }
    public double getArea(){
        return side*side*3*Math.sqrt(3)/2;
    }
    public double getPerimeter(){
        return 6*side;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat d = new DecimalFormat("#.####");// ����4λС��
        double side = input.nextDouble();

        shape rh = new RHexagon(side);

        System.out.println(d.format(rh.getArea()));
        System.out.println(d.format(rh.getPerimeter()));
        input.close();
    }
}

