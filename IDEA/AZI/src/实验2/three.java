package 实验2;
import java.util.Scanner;
public class three {
}
class LinearEquation{
    private double a,b,c,d,e,f;
    public LinearEquation() {
        Scanner scanf = new Scanner(System.in);
        System.out.println("请输入a,b,c,d,e,f");
        double a = scanf.nextDouble();
        double b = scanf.nextDouble();
        double c = scanf.nextDouble();
        double d = scanf.nextDouble();
        double e = scanf.nextDouble();
        double f = scanf.nextDouble();
        LinearEquation group1 = new LinearEquation(a, b, c, d, e, f);

        boolean flag = group1.isSolvable();
        if (flag) {
            System.out.println("x的值为: " + group1.getX());
            System.out.println("y的值为: " + group1.getY());
        } else {
            System.out.println("The equation has no solution.");
        }
    }
    public LinearEquation(double a,double b,double c,double d,double e,double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getD() {
        return d;
    }
    public double getE() {
        return e;
    }
    public double getF() {
        return f;
    }
    public boolean isSolvable(){
        if((a*d-b*c)==0){
            return false;
        }
        else{
            return true;
        }
    }
    public double getX() {
        return (e*d-b*f)/(a*d-b*c);
    }
    public double getY() {
        return (a*f-e*c)/(a*d-b*c);
    }
}
