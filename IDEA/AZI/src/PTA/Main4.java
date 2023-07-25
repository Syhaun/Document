package PTA;

import java.util.Scanner;
import java.lang.StringBuffer;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ch = in.next();
        StringBuffer S = new StringBuffer(ch);
        for (int i = 0; i < S.length(); i++) {
            if(Character.isUpperCase(S.charAt(i))){
                 S.insert(i,'_');
                 i++;
                S.setCharAt(i,(char)(S.charAt(i)+32));
            }
        }

        System.out.println(S);
    }
}