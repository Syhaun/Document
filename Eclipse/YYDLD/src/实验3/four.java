package สตั้3;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter list1: ");
        int m1[][] = new int [3][3];
        int m2[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter list2: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = in.nextInt();
            }
        }
        if(equals(m1,m2)){
            System.out.println("The two arrays are identical");
        }
        else{
            System.out.println("The tow arrays are not identical");
        }
    }
    public static boolean equals(int[][] m1,int[][] m2){
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if(m1[i][j]!=m2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
