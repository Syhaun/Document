package AZIY;
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
    RHexagon (double side){
        this.side = side;
    }

    @Override
    public double getArea() {
        return (3*Math.sqrt(3)/2*side*side);
    }
    @Override
    public double getPerimeter(){
        return (6*side);
    }
}

public class sdsd {
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


