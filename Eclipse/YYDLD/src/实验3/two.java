package ʵ��3;

import java.util.Scanner;
import java.util.SplittableRandom;

public class two {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("������ѧ������");
        int n= in.nextInt();
        String []name=new String[n];
        int []score=new int[n];
        System.out.println("������ѧ�������������ǵķ���");
        for (int i = 0; i < n; i++) {
            name[i]=in.next();
            score[i]= in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                if(score[i]<score[j]){
                    int temp=score[i];
                    String tem=name[i];
                    score[i]=score[j];
                    name[i]=name[j];
                    score[j]=temp;
                    name[j]=tem;
                }
            }
        }
        System.out.println("���ǵ�����������");
        for (int i = 0; i < n; i++) {
            System.out.println(name[i]);
        }
    }
}
