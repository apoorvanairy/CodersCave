import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int age;
    private String gender;
    private String studentClass;
    private Map<String, Integer> grades;

    public Student(String studentId, String name, int age, String gender, String studentClass) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.studentClass = studentClass;
        this.grades = new HashMap<>();
    }

    public void updateInfo(String name, Integer age, String gender, String studentClass) {
        if (name != null) this.name = name;
        if (age != null) this.age = age;
        if (gender != null) this.gender = gender;
        if (studentClass != null) this.studentClass = studentClass;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Class: " + studentClass);
        System.out.println("Grades: " + grades);
    }
 public String getStudentId() {
        return studentId;
    }
}

class StudentInformationSystem {
    private Map<String, Student> students;

    public StudentInformationSystem() {
        this.students = new HashMap<>();
    }

    public void addStudent(String studentId, String name, int age, String gender, String studentClass) {
        if (students.containsKey(studentId)) {
            System.out.println("Student with ID " + studentId + " already exists.");
        } else {
            Student student = new Student(studentId, name, age, gender, studentClass);
            students.put(studentId, student);
            System.out.println("Student " + name + " added successfully.");
        }
    }

    public void updateStudent(String studentId, String name, Integer age, String gender, String studentClass) {
        Student student = students.get(studentId);
        if (student != null) {
            student.updateInfo(name, age, gender, studentClass);
            System.out.println("Student ID " + studentId + "'s information updated.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void viewStudent(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            student.displayStudent();
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
 public void deleteStudent(String studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            System.out.println("Student ID " + studentId + " deleted from the system.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students.values()) {
                student.displayStudent();
                System.out.println();
            }
        }
    }

    public void addStudentGrade(String studentId, String subject, int grade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.addGrade(subject, grade);
            System.out.println("Grade added for Student ID " + studentId + " in subject " + subject + ".");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();
        Scanner sc = new Scanner(System.in);
        
        // Example usage
        sis.addStudent("S001", "John Doe", 16, "Male", "10th Grade");
        sis.addStudent("S002", "Jane Smith", 17, "Female", "11th Grade");

        // View specific student details
        sis.viewStudent("S001");

  // Update student information
        sis.updateStudent("S002", null, 18, null, null);

        // Add grades to student
        sis.addStudentGrade("S001", "Math", 85);
        sis.addStudentGrade("S002", "Science", 90);

        // View all students
        sis.viewAllStudents();

        // Delete student
        sis.deleteStudent("S002");

        // View all students after deletion
        sis.viewAllStudents();

        sc.close();
    }
}
