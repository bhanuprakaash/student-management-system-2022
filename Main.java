import dao.Dao;
import dao.StudentDao;
import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {


    private static final int ADD_STUDENT=1;
    private static final int UPDATE_STUDENT=2;
    private  static final int GET_STUDENTS=3;
    private static final int DELETE_ACCOUNT = 4;

    public static void main(String[] args) {
        int userOption;
        Scanner scanner = new Scanner(System.in);
        Dao<Student> dao = new StudentDao();
        StudentService studentService = new StudentService(dao);
        do{
            studentService.showMenu();
            userOption= scanner.nextInt();
            switch (userOption) {
                case ADD_STUDENT -> {
                    Student studentToAdd = new Student();
                    System.out.println("Enter the Student Details: ");
                    System.out.print("Student Id: ");
                    studentToAdd.setStudentId(scanner.next());
                    System.out.print("First Name: ");
                    studentToAdd.setFirstName(scanner.next());
                    System.out.print("Last Name: ");
                    studentToAdd.setLastName(scanner.next());
                    System.out.println();
                    studentService.addStudent(studentToAdd);
                    System.out.println();
                }
                case UPDATE_STUDENT -> {
                    System.out.print("Enter the StudentId to update: ");
                    String studentId = scanner.next();
                    Student student = studentService.getStudentById(studentId);
                    System.out.printf("%s%s%s","Enter the studentId (",student.getStudentId(),") : ");
                    student.setStudentId(scanner.next());
                    System.out.printf("%s%s%s","Enter the First Name (",student.getFirstName(),") : ");
                    student.setFirstName(scanner.next());
                    System.out.printf("%s%s%s","Enter the Last Name (",student.getLastName(),") : ");
                    student.setLastName(scanner.next());
                    studentService.updateStudent(student);
                    System.out.println();
                }
                case GET_STUDENTS -> {
                    studentService.getAllStudents();
                    System.out.println();
                }
                case DELETE_ACCOUNT->{
                    System.out.print("Enter the id to delete: ");
                    String id= scanner.next();
                    studentService.deleteStudent(id);
                    System.out.println();
                }
                default -> System.out.println("No Such Item");
            }
        }while(userOption<5);
    }
}