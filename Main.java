import dao.Dao;
import dao.StudentDao;
import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {

    private static StudentService studentService;
    private static final int ADD_STUDENT=1;
    private static final int UPDATE_STUDENT=2;
    private  static final int GET_STUDENTS=3;
    private static final int DELETE_ACCOUNT = 4;

    public static void main(String[] args) {
        int userOption;
        Scanner scanner = new Scanner(System.in);
        Dao<Student> dao = new StudentDao();
        studentService = new StudentService(dao);
        do{
            studentService.showMenu();
            userOption= scanner.nextInt();
            switch (userOption) {
                case ADD_STUDENT -> {
                    System.out.println("Enter the Student Details: ");
                    System.out.print("Student Id: ");
                    String studentId= scanner.next();
                    System.out.print("First Name: ");
                    String firstName=scanner.next();
                    System.out.print("Last Name: ");
                    String lastName=scanner.next();
                    System.out.println();
                    studentService.addStudent(new Student(studentId,firstName,lastName));
                    System.out.println();
                }
                case UPDATE_STUDENT -> {
                    System.out.print("Enter the StudentId to update: ");
                    String studentId = scanner.next();
                    Student student = studentService.getStudentById(studentId);
                    System.out.printf("%s%s%s","Enter the studentId (",student.getStudentId(),") : ");
                    String newId=scanner.next();
                    System.out.printf("%s%s%s","Enter the studentId (",student.getFirstName(),") : ");
                    String firstName = scanner.next();
                    System.out.printf("%s%s%s","Enter the studentId (",student.getLastName(),") : ");
                    String lastName=scanner.next();
                    studentService.updateStudent(student,new String[]{newId,firstName,lastName});
                    System.out.println();
                }
                case GET_STUDENTS -> {
                    studentService.getAllStudents();
                    System.out.println();
                }
                case DELETE_ACCOUNT->{
                    System.out.print("Enter the id to delete: ");
                    String id= scanner.next();
                    Student student = studentService.getStudentById(id);
                    studentService.deleteStudent(student);
                    System.out.println();
                }
                default -> {
                    System.out.println("No Such Item");
                }
            }


        }while(userOption<5);
    }
}