package 实验3;

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入10个double型数字");
        double[] list = new double[10];
        for (int i = 0; i < 10; i++) {
            list[i] = in.nextDouble();
        }
        SelectionSort.selectionSort(list);
        for (double num : list) {
            System.out.println(num);
        }
    }
}
class SelectionSort{
    public static void selectionSort(double []list)
    {
        for (int i = list.length-1; i >1; i--) {
            double currentMax=list[i];
            int currentMaxIndex=i;
            for (int j = list.length-2; j > 0; j--) {
                if(currentMax < list[j]){
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
            if(currentMaxIndex!=i){
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }
}