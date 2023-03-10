package presentation;

import dao.Dao;
import dao.StudentDao;
import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userOption;
        Scanner scanner = new Scanner(System.in);
        Dao<Student> dao = new StudentDao();
        StudentService studentService = new StudentService(dao);
        Menu menu = new Menu();
        do{
            menu.showMenu();
            userOption= scanner.nextInt();
            switch (userOption) {
                case Menu.ADD_STUDENT -> {
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
                case Menu.UPDATE_STUDENT -> {
                    System.out.print("Enter the StudentId to update: ");
                    String studentId = scanner.next();
                    Student student = studentService.getStudentById(studentId);
                    System.out.printf("Enter the First Name (%s): ", student.getFirstName());
                    student.setFirstName(scanner.next());
                    System.out.printf("Enter the Last Name (%s): ", student.getLastName());
                    student.setLastName(scanner.next());
                    studentService.updateStudent(student);
                    System.out.println();
                }
                case Menu.GET_STUDENTS -> {
                    List<Student> students = studentService.getAllStudents();
                    System.out.printf("%-15s%-15s%-15s%n","Student Id","First Name","Last Name");
                    students.stream().forEach(student ->
                            System.out.printf("%-15s%-15s%-15s%n",student.getStudentId(),student.getFirstName(),student.getLastName())
                    );
                    System.out.println();
                }
                case Menu.DELETE_STUDENT->{
                    System.out.print("Enter the id to delete: ");
                    String id= scanner.next();
                    studentService.deleteStudent(id);
                    System.out.println();
                }
                case Menu.EXIT -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("No Such Item");
            }
        }while(userOption!=Menu.EXIT);
    }
}