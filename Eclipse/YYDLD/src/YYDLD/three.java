package YYDLD;
import java.util.Scanner;

public class three {
public static void main(String[] args) {
				Scanner scanf=new Scanner(System.in);
				double a,b,c;
				System.out.println("Ener a,b,c:");
				a=scanf.nextDouble();
				b=scanf.nextDouble();
				c=scanf.nextDouble();
				double triangle,r1,r2;
				triangle=Math.sqrt(Math.pow(b,2)-4*a*c);
				if(triangle>0)
				{
					r1=(-b+triangle)/(2*a);
					r2=(-b-triangle)/(a*2);
					System.out.format("The roots are %f and %f",r1,r2);
		
				}
				if(triangle==0)
				{
					r1=(-b)/(a*2);
					System.out.format("The root is %f",r1);
				}
				else
				{
					System.out.println("The equation has no real roots");
				}
				
}
	
}
