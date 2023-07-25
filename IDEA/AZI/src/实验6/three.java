package สตั้6;

import java.util.ArrayList;

public class three {
    public static void main(String[] args) {
        Course coures1 = new Course("Data Structures");
        Course coures2 = new Course("Database Systems");

        coures1.addStudent("Peter Jones");
        coures1.addStudent("Kim Smith");
        coures1.addStudent("Anne Kennedy");

        coures2.addStudent("Peter Jones");
        coures2.addStudent("Steve Smith");

        System.out.println("Number of student in course1: " + coures1.getNumberOfStudents());
        ArrayList<String> students = coures1.getStudents();
        for (int i = 0; i < coures1.getNumberOfStudents(); i++) {
            System.out.print(students.get(i) + ", ");
        }
        System.out.println();
        System.out.println("Number of students in course2: " + coures2.getNumberOfStudents());
    }
}
class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<String>(100);
    private int numberOfStudents;
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }
    public ArrayList<String> getStudents() {
        return students;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public String getCourseName() {
        return courseName;
    }
    public void dropStudent(String student) {

    }
}
