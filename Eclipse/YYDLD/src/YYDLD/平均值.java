package YYDLD;
import java.util.Scanner;
public class ƽ��ֵ {
	public static void main(String[] args) {
		Scanner scanf=new Scanner(System.in);
		int n=scanf.nextInt();
		double[]numbers=new double[n];
		double sum=0;
		System.out.println("������"+n+"������");
		for(int i=0;i<n;i++)
		{
			numbers[i]=scanf.nextDouble();
			sum+=numbers[i];
		}
		double average=sum/n;
		int count=0;
		for(double num:numbers) {
			if(num>average)
				count++;
		}
		System.out.println("Average is "+average);
		System.out.println("Number of elements above the average is "+count);
	}

}
