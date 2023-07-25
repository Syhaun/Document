package ÊµÑé5;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first string£º");
        String S1 = new String();
        S1 = in.next();
        System.out.println("Enter the second string: ");
        String S2 = new String();
        S2 = in.next();
        int i = 0;
        while(i<S1.length()&&i<S2.length()&&S1.charAt(i)==S2.charAt(i)){
            i++;
        }
        String result = S1.substring(0,i);
        if(result.length()==0)
            System.out.println("Atlanta and Macon have no common prefix");
        else {
            System.out.println("The common prefix is "+result);
        }
    }
}
