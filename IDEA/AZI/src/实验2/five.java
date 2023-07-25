package สตั้2;

public class five {
    public static void main(String[] args) {


}}
class MyPoint{
    private double x,y;
    public MyPoint() {
        x=0;
        y=0;
    }
    public MyPoint(double x,double y) {
        this.x=x;
        this.y=y;
    }
    public double distance() {
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
    public double distance(double x,double y) {
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
 }

