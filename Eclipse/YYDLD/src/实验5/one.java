package 实验5;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("请输入成绩单中学生的个数");
        n = in.nextInt();
        scoreStudent[] sc =new scoreStudent[n];
        System.out.println("请依次输入学生的姓名和成绩");
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
        System.out.println("他们的总成绩为："+sum);
        System.out.println("他们的平均成绩为："+average);
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