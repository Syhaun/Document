package ʵ��6;

import jdk.dynalink.beans.StaticClass;

import java.util.Date;

public class two {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.toString());
        Student student = new Student("��һͻ����ţүү","������԰","12121212121","4545@qq.com");
        System.out.println(student.toString());
        Employee employee = new Employee("��΢�Ĵ���","����һƷ","11015","4564654@qq.com","�׹�",100000000);
        System.out.println(employee.toString());
        Faculty faculty = new Faculty("�ŵ»�","С����","110120119","110120119@163.com","Fz101",1,"ÿ�칤��24Сʱ","����");
        System.out.println(faculty.toString());
        Staff staff = new Staff("�޹ܰ���","���ñ�","454151","4545@qq.com","һ¥",5020,"��ţ���޹�");
        System.out.println(staff.toString());
    }
}
class Person {
    public String name = new String("�ŵ»�");
    public String address = new String("С����");
    public  String phoneNumber = new String("110120119");
    public  String e_mail = new String("110120119@163.com");

    public Person() {

    }

    public Person(String name,String address,String phoneNumber,String e_mail) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "����Ϊ��Person" + " " + " ������Ϣ" + "  ����:" + name + "  ��ַ:" + address + "  �绰:" + phoneNumber + "  ����:" + e_mail;
    }
}
class Student extends Person {
    public final String grade = new String("��һ");
    public Student(String name,String address,String phoneNumber,String e_mail) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
    }


    @Override
    public String toString() {
        return "����Ϊ��Student" + " " + " ������Ϣ" + "  ����:" + name + "  ��ַ:" + address + "  �绰:" + phoneNumber + "  ����:" + e_mail + "  �꼶:" + grade;
    }
}
class Employee extends Person {
    public String office;
    public int salary;
    public Date date = new Date();

    public Date getDate() {
        return date;
    }

    public Employee(){

    }
    public Employee(String name,String address,String phoneNumber,String e_mail,String office,int salary) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
        this.office = office;
        this.salary = salary;
    }
    public String toString() {
        return "����Ϊ��Employee" + " " + " ������Ϣ" + "  ����:" + name + "  ��ַ:" + address + "  �绰:" + phoneNumber + "  ����:" + e_mail + "  �칫��:" + office + "  нˮ:" + salary + "  ��Ƹ����:" + date;
    }

}
//��Ա
class Faculty extends Employee {
    public String time;
    public String level;
    public Faculty(String name,String address,String phoneNumber,String e_mail,String office,int salary,String time,String level) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
        this.office = office;
        this.salary = salary;
        this.time = time;
        this.level = level;
    }
    public String toString() {
        return "����Ϊ��Faculty" + " " + " ������Ϣ" + "  ����:" + name + "  ��ַ:" + address + "  �绰:" + phoneNumber + "  ����:" + e_mail + "  �칫��:" + office + "  нˮ:" + salary + "  ��Ƹ����:" + date+
        "  �칫ʱ��:"+ time + "  ����:" + level;
    }
}
//ְԱ
class Staff extends Employee {
    public String title;
    public Staff(String name,String address,String phoneNumber,String e_mail,String office,int salary,String title) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
        this.office = office;
        this.salary = salary;
        this.title = title;
    }
    public String toString() {
        return "����Ϊ��Staff" + " " + " ������Ϣ" + "  ����:" + name + "  ��ַ:" + address + "  �绰:" + phoneNumber + "  ����:" + e_mail + "  �칫��:" + office + "  нˮ:" + salary + "  ��Ƹ����:" + date +
         "  ͷ��:" + title;
    }
}
