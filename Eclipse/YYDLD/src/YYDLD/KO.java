package YYDLD;
import java.util.Scanner;
public class KO {
	 public static void main(String[] args)
	 {
		 Scanner scanf=new Scanner(System.in);
		int n;
		 n=scanf.nextInt();
		 int [] d=new int[n];
		 for(int i=0;i<n;i++)
		 {
			 d[i]=scanf.nextInt();
		 }
		 int result=0;
		 for(int i=0;i<n;i++)
		 {
			 result^=d[i];
		 }
		 System.out.println(result);
	 }

}
