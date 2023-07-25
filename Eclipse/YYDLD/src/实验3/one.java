package สตั้3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Random random = new Random();
        int []arr=new int[1000000];
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt();
        }
        int key = random.nextInt();
        long startTime = System.currentTimeMillis();
        int linearIndex = lineraSearch(arr,key);
        long endTime = System.currentTimeMillis();
        long linearExecutionTime = endTime - startTime;

        Arrays.sort(arr);
        startTime = System.currentTimeMillis();
        int binaryIndex = Arrays.binarySearch(arr,key);
        endTime = System.currentTimeMillis(); 
        long binaryExecutionTime = endTime - startTime;

        System.out.println("Execution time of linear search: " + linearExecutionTime + "ns");
        System.out.println("Execution time of binary search: " + binaryExecutionTime + "ns");
    }
    public static int lineraSearch(int[]arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
