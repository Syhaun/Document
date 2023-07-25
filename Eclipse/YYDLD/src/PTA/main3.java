package PTA;

import java.math.BigInteger;
import java.util.Scanner;

public class main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger m = new BigInteger(in.nextLine());
		int n = in.nextInt();
		int count = 0;
		for(int i = 0; i < n; i++) {
			m = m.nextProbablePrime();
			System.out.println(m);
		}
	}
}
