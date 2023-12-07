package StudyDemo;



/*
* 对一个对象数组进行排序
* 开发一个泛型方法,对一个Comparable对象数组进行排序
*
* */
public class GenericSort {
    public static void main(String[] args) {
        //创建一个整数数组
        Integer[] intArray = {Integer.valueOf(2),Integer.valueOf(4),Integer.valueOf(3)};
        //创建一个浮点型数组
        Double[] doubelArray = {Double.valueOf(3.4),Double.valueOf(1.3),Double.valueOf(-22.1)};
        //创建一个字符数组
        Character[] charArray = {Character.valueOf('a'),Character.valueOf('J'),Character.valueOf('r')};
        //创建一个字符型数组
        String[] stringArray = {"Tom","Susan","Kim"};
        sort(intArray);
        sort(doubelArray);
        sort(charArray);
        sort(stringArray);

        System.out.print("整数对象排序:" );
        printList(intArray);
       System.out.print("浮点型对象排序" );
       printList(doubelArray);
        System.out.print("字符型对象排序");
        printList(charArray);
        System.out.print("字符串类型排序" );
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
