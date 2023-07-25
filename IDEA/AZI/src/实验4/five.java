package สตั้4;

import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Emter a strimg : ");
        String ch = in.nextLine();


        int count = 0;
        for (int i = 0; i < ch.length(); i++) {
                if(Character.isUpperCase(ch.charAt(i))){
                    count++;
                }
        }
        System.out.println("The number of Uppercase letters is "+ count);
    }
}
