package ʵ��5;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("������ɼ�����ѧ���ĸ���");
        n = in.nextInt();
        scoreStudent[] sc =new scoreStudent[n];
        System.out.println("����������ѧ���������ͳɼ�");
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int score = in.nextInt();
            sc[i] = new scoreStudent(name,score);
        }
        double average = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=sc[i].score;
        }
        average = (double) sum/n;
        System.out.println("���ǵ��ܳɼ�Ϊ��"+sum);
        System.out.println("���ǵ�ƽ���ɼ�Ϊ��"+average);
    }
}
class scoreStudent{
    String name;
    int score;
    scoreStudent(String name,int score)
    {
        this.name = name;
        this.score = score;
    }
}