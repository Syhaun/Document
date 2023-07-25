package YYDLD;
import java.util.Scanner;
public class twof {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根;
		Scanner scanf=new Scanner(System.in);
		double x1,x2,x3,y1,y2,y3;
		System.out.print("Enter three points for a triangle:");
		x1=scanf.nextDouble();
		y1=scanf.nextDouble();
		x2=scanf.nextDouble();
		y2=scanf.nextDouble();
		x3=scanf.nextDouble();
		y3=scanf.nextDouble();
	double area,s,s1,s2,s3;
	s1=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	s2=Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
	s3=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
	s=(s1+s2+s3)/2;
	area=Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	System.out.format("The area of the triangle is %.1f",area);
	}

}
