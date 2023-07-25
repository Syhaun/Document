package YYDLD;
public class Main {

    public static void main(String[] args) {
        Student stu1 = new Student(5, "Bill", 87);
        stu1.print();

        Student stu2 = new Student(2, "Adam", 91);
        stu2.print();

        Student stu3 = new Student(3, "David", 96);
        stu3.print();

        Student.average();
    }
}
class Student{
    private int number;
    private String name;
    private float score;
    private static int count=0;
    private static float sum=0;
    
    public Student(){

    }
    public Student(int number1, String name1, float score1){
        number=number1;
        name=name1;
        score=score1;
        sum+=score;
        count++;
    }
    public void setname(String name1) {
      name=name1;
     }
    public String getname(){
        return name;
    }

    public void setnumber(int number1) {
      number=number1;
     }
    public int getnumber(){
        return number;
    }
    
    public void setscore(float score1) {
      score=score1;
     }
    public float getscore(){
        return score;
    }
     public void print() {
        System.out.println("number: " +number+ " name: " +name+ " score: " +score+ " count: " + count);
    }

    public static void average() {
        System.out.println("sum is " + sum + "\tcount is "+count);
        System.out.println("average is " + sum / count);
    }
    
}
