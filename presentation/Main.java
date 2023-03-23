package presentation;

import dao.Dao;
import dao.StudentDao;
import model.Student;
import service.StudentService;
import exceptions.NoSuchStudentIdExistsException;
import exceptions.StudentIdAlreadyExistsException;

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
                    try {
                        studentService.addStudent(studentToAdd);
                    } catch (StudentIdAlreadyExistsException e) {
                        System.err.println(e.getMessage());
                        break;
                    }
                    System.out.println();
                }
                case Menu.UPDATE_STUDENT -> {
                    System.out.print("Enter the StudentId to update: ");
                    String studentId = scanner.next();
                    Student student;
                    try{
                        student = studentService.getStudentById(studentId);
                    }
                    catch (NoSuchStudentIdExistsException e){
                        System.err.println(e.getMessage());
                        break;
                    }
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
                case Menu.SHOW_AND_SORT_STUDENTS -> {
                    System.out.println("1: Sort by Student Id");
                    System.out.println("2: Sort by First Name");
                    System.out.println("3: Sort by Last Name");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    System.out.printf("%-15s%-15s%-15s%n","Student Id","First Name","Last Name");
                    switch (choice){
                        case 1 -> studentService.sortStudentsById().forEach(student ->
                                System.out.printf("%-15s%-15s%-15s%n",student.getStudentId(),student.getFirstName(),student.getLastName())
                        );
                        case 2 -> studentService.sortStudentsByFirstName().forEach(student ->
                                System.out.printf("%-15s%-15s%-15s%n",student.getStudentId(),student.getFirstName(),student.getLastName())
                        );
                        case 3 -> studentService.sortStudentsByLastName().forEach(student ->
                                System.out.printf("%-15s%-15s%-15s%n",student.getStudentId(),student.getFirstName(),student.getLastName())
                        );
                        default -> System.out.println("No Such Item");
                    }
                    System.out.println();
                }
                case Menu.DELETE_STUDENT->{
                    System.out.print("Enter the id to delete: ");
                    String id= scanner.next();
                    try{
                        studentService.deleteStudent(id);
                    }
                    catch (NoSuchStudentIdExistsException e){
                        System.err.println(e.getMessage());
                    }
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