package สตั้2;

public class six {
    public static void main(String[] args) {
    RegularPolygon rp1=new RegularPolygon();
    RegularPolygon rp2=new RegularPolygon(6,4);
    RegularPolygon rp3=new RegularPolygon(10,4,5.6,7.8);
System.out.println(rp1.getPerimeter()+"  "+rp1.getArea());
System.out.println(rp2.getPerimeter()+"  "+rp2.getArea());
System.out.println(rp3.getPerimeter()+"  "+rp3.getArea());

    }
}
class RegularPolygon{
    private int n=3;
    private double side=1,x=0,y=0;
    public RegularPolygon(){

    }
    public RegularPolygon(int n,double side) {
        this.n=n;
        this.side=side;
        this.x=0;
        this.y=0;
    }

    public RegularPolygon(int n,double side,double x,double y) {
        this.n=n;
        this.side=side;
        this.x=x;
        this.y=y;
    }
    public int getn() {
        return n;
    }
    public void setn(int n) {
        this.n=n;
    }
    public double getside() {
        return side;
    }
    public void setside(double side) {
        this.side=side;
    }
    public double getx() {
        return x;
    }
    public void setx(double x) {
        this.x=x;
    }
    public double gety() {
        return y;
    }
    public void sety(double y) {
        this.y=y;
    }
    public double getPerimeter() {
        return n*side;
    }
    public double getArea() {
        return n*side*side/(4*Math.tan(Math.PI/n));
    }

}