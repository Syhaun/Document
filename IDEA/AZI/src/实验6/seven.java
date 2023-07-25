package สตั้6;

public class seven {
    public static void main(String[] args) {
        Octagon octagon = new Octagon(5);
        Octagon octagon1 = (Octagon) octagon.clone();
        System.out.println(octagon.compareTo(octagon1));
        System.out.println(octagon.equals(octagon1));
    }
}
class Octagon extends GeometricObject implements Comparable<Octagon>,Cloneable{
    private double side = 0.0;
    Octagon() {

    }
    Octagon(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public int compareTo(Octagon o) {
        if(o.side == this.side)
            return 1;
        return 0;
    }
    double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }
    double getPerimeter () {
        return 8 * side;
    }
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }

}
