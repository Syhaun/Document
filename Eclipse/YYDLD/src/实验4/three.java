package ʵ��4;

import java.util.GregorianCalendar;

public class three {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        int curYear = calendar.get(GregorianCalendar.YEAR);
        int curMonth = calendar.get(GregorianCalendar.MONTH)+1;
        int curDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        System.out.println("��ǰ������Ϊ"+curYear+ "��" + curMonth +"��" + curDay + "��");
        calendar.setTimeInMillis(1234567898765L);
        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH)+1;
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        System.out.println("1234567898765L����ʾ��������" + year +"��" + month + "��" + day + "��" );


    }

}
