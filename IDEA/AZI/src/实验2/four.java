package ʵ��2;

public class four {
    public static void main(String[] args) {
        MyInteger mi = new MyInteger(0);

        System.out.println(mi.getValue());

        System.out.println(mi.isEven() + " " + mi.isOdd() + " " + mi.isPrime());

        System.out.println(MyInteger.isEven(2) + " " + MyInteger.isOdd(2) + " " + MyInteger.isPrime(2));

        MyInteger mi_pro = new MyInteger(2); System.out.println(MyInteger.isEven(mi_pro) + " " + MyInteger.isOdd(mi_pro) +" " + MyInteger.isPrime(mi_pro));

        char[] ch = {'1', '2', '3'};


        String str = "123";
     // System.out.print(MyInteger.parseInt(str));
    }
}
class MyInteger {
    // int��������
    static int value;
    // �вι��췽��
    public MyInteger(int num){
        value = num;
    }
    // ��ȡvalue
    public int getValue() {
        return value;
    }
    // �����������ж϶����е�ֵ
    public boolean isEven(){
        return value % 2 == 0;
    }
    public boolean isOdd(){
        return value % 2 == 1;
    }
    public boolean isPrime(){
        return havePrimeNumber(value);
    }
    // �ж�ָ��ֵ��int�ͣ�
    public static boolean isEven(int num){
        return num % 2 == 0;
    }
    public static boolean isOdd(int num){
        return num % 2 == 1;
    }
    public static boolean isPrime(int num){
        return havePrimeNumber(value);
    }
    // �ж�ָ��ֵ��MyInteger�ͣ�
    public static boolean isEven(MyInteger mi){
        return mi.isEven(mi.value);
    }
    public static boolean isOdd(MyInteger mi){
        return mi.isOdd(mi.value);
    }
    public static boolean isPrime(MyInteger mi){
        return havePrimeNumber(mi.value);
    }
    // +: �ж�һ�����Ƿ�������
    public static boolean havePrimeNumber(int num){
        boolean bool = true;
        for (int i = 2 ; i <= num / 2 ; i++){
            if (num % i != 0){
                bool = false;
            }
        }
        return bool;
    }}
    // �ж�ֵ�Ƿ����
