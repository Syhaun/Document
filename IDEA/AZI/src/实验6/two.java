package 实验6;

import jdk.dynalink.beans.StaticClass;

import java.util.Date;

public class two {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.toString());
        Student student = new Student("第一突破手牛爷爷","翻斗花园","12121212121","4545@qq.com");
        System.out.println(student.toString());
        Employee employee = new Employee("卑微的打工仔","汤臣一品","11015","4564654@qq.com","白宫",100000000);
        System.out.println(employee.toString());
        Faculty faculty = new Faculty("张德慧","小破邮","110120119","110120119@163.com","Fz101",1,"每天工作24小时","教授");
        System.out.println(faculty.toString());
        Staff staff = new Staff("宿管阿姨","安悦北","454151","4545@qq.com","一楼",5020,"最牛逼宿管");
        System.out.println(staff.toString());
    }
}
class Person {
    public String name = new String("张德慧");
    public String address = new String("小破邮");
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
        return "类名为：Person" + " " + " 人物信息" + "  名字:" + name + "  地址:" + address + "  电话:" + phoneNumber + "  邮箱:" + e_mail;
    }
}
class Student extends Person {
    public final String grade = new String("大一");
    public Student(String name,String address,String phoneNumber,String e_mail) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
    }


    @Override
    public String toString() {
        return "类名为：Student" + " " + " 人物信息" + "  名字:" + name + "  地址:" + address + "  电话:" + phoneNumber + "  邮箱:" + e_mail + "  年级:" + grade;
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
        return "类名为：Employee" + " " + " 人物信息" + "  名字:" + name + "  地址:" + address + "  电话:" + phoneNumber + "  邮箱:" + e_mail + "  办公室:" + office + "  薪水:" + salary + "  受聘日期:" + date;
    }

}
//教员
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
        return "类名为：Faculty" + " " + " 人物信息" + "  名字:" + name + "  地址:" + address + "  电话:" + phoneNumber + "  邮箱:" + e_mail + "  办公室:" + office + "  薪水:" + salary + "  受聘日期:" + date+
        "  办公时间:"+ time + "  级别:" + level;
    }
}
//职员
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
        return "类名为：Staff" + " " + " 人物信息" + "  名字:" + name + "  地址:" + address + "  电话:" + phoneNumber + "  邮箱:" + e_mail + "  办公室:" + office + "  薪水:" + salary + "  受聘日期:" + date +
         "  头衔:" + title;
    }
}
