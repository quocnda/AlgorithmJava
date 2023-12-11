import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String firstName;
    private String lastName;

    public Student() {
        firstName = "";
        lastName = "";
    }
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

   
}

public class Studentsort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Alice", "Smith"));
        students.add(new Student("Bob", "Johnson"));
        students.add(new Student("Eve", "Anderson"));
        Comparator<Student> student = new Comparator<Student>() {
             @Override
            public int compare(Student student1, Student student2) {
                String name1 = student1.getLastName() + " " + student1.getFirstName();
                String name2 = student2.getLastName() + " " + student2.getFirstName();
                return name1.compareTo(name2);
            }
        };
        // Sử dụng Comparator để sắp xếp theo họ tên
        Collections.sort(students, student);

        // In danh sách sinh viên đã sắp xếp
        for (Student student1 : students) {
            System.out.println(student1);
        }
    }
}
