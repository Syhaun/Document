package StudyDemo;



/*
* ��һ�����������������
* ����һ�����ͷ���,��һ��Comparable���������������
*
* */
public class GenericSort {
    public static void main(String[] args) {
        //����һ����������
        Integer[] intArray = {Integer.valueOf(2),Integer.valueOf(4),Integer.valueOf(3)};
        //����һ������������
        Double[] doubelArray = {Double.valueOf(3.4),Double.valueOf(1.3),Double.valueOf(-22.1)};
        //����һ���ַ�����
        Character[] charArray = {Character.valueOf('a'),Character.valueOf('J'),Character.valueOf('r')};
        //����һ���ַ�������
        String[] stringArray = {"Tom","Susan","Kim"};
        sort(intArray);
        sort(doubelArray);
        sort(charArray);
        sort(stringArray);

        System.out.print("������������:" );
        printList(intArray);
       System.out.print("�����Ͷ�������" );
       printList(doubelArray);
        System.out.print("�ַ��Ͷ�������");
        printList(charArray);
        System.out.print("�ַ�����������" );
        printList(stringArray);


    }
    public static <E extends Comparable<E>> void sort(E[] list)
    {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length - 1; i++) {
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i + 1; j < list.length ; j++) {
                if(currentMin.compareTo(list[j]) > 0)
                {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i)
            {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    public  static void printList(Object[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
