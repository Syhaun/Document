package 实验4;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = in.nextLine();
        System.out.println(sort(s));
    }
    public static String sort(String s) {
            char[] ch = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if(ch[i]>ch[j]){
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }
        return new String(ch);
    }
}
