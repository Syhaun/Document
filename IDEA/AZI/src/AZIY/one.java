package AZIY;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入一个字符串和一个字符：");
        String word = in.next();
        char ch = in.next().charAt(0);
        System.out.println("结果是：");
        System.out.println(hahaha(word,ch));
    }

    public static String  hahaha(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
            return sb.reverse().append(word.substring(index + 1)).toString();
        }
        return word;
    }
}

