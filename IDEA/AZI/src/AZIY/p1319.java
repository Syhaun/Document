package AZIY;
import java.util.Arrays;
import java.util.Scanner;


public class  p1319 {
    public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    int row=1,column=1;
        int n=input.nextInt();
    int [][]arr=new int[n+1][n+1];
    for(int i=0;i<n;i++){
        Arrays.fill(arr[i],0);
    }
    int sum=0;
    int temp=0;
    while(sum<n*n){
        int m= input.nextInt();
        temp++;
        for(int i=1;i<=m;i++){
            if(temp%2==1)
            {arr[row][column]=0;}
            else{arr[row][column]=1;}
                column++;
                sum++;
                if(column==n+1){
                    row++;
                    column=1;
                }
            }

        }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            System.out.print(arr[i][j]);
        }
        System.out.println("\n");
    }


    }
}
