package 实验2;

import java.util.Scanner;

public class tow {
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        System.out.println("请输入3个数字a,b,c: ");
        double a= scanf.nextDouble();
        double b= scanf.nextDouble();
        double c= scanf.nextDouble();
        QuadraticEquation group1=new QuadraticEquation(a,b,c);
        double triangle= group1.getDiscriminant();
        if(triangle>0){
            System.out.println("the Rool1 is"+group1.getRoot1(triangle));
            System.out.println("the Rool2 is"+group1.getRoot2(triangle));
        } else if (triangle==0) {
            System.out.println("the Rool1 is"+group1.getRoot1(triangle));
        }
        else{
            System.out.println("The equation has no roots.");
        }
    }
}
class QuadraticEquation{
    private double a,b,c;
    public  QuadraticEquation(){

    }
    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getDiscriminant(){
        double triangle=b*b-4*a*c;
        if(triangle<0)
        {
            return -1;
        }
        else
        {
            return triangle;
        }
    }
    public double getRoot1(double triangle){
        double r1=(-b+Math.sqrt(triangle))/2;
        return r1;
    }
    public double getRoot2(double triangle){
        double r2=(-b+Math.sqrt(triangle))/2;
        return r2;
    }
}