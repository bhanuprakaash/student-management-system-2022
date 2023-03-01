package service;

import dao.Dao;
import model.Student;

import java.util.Iterator;

public class StudentService {
    private final Dao<Student> studentDao;

    public StudentService(Dao<Student> studentDao){
        this.studentDao = studentDao;
    }

    public Student getStudentById(String id){
        Student student = studentDao.get(id).get();
        return student;
    }

    public void getAllStudents(){
        System.out.println();
        Iterator<Student> iterator = studentDao.getAll().iterator();
        System.out.printf("%-12s %-20s %s%n", "StudentId", "FirstName", "LastName");
        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.printf("%-12s %-20s %s%n",student.getStudentId(),student.getFirstName(),student.getLastName() );
        }
    }

    public void addStudent(Student student){
        studentDao.save(student);
    }

    public void updateStudent(Student student,String[] params){
        studentDao.update(student,params);
    }

    public void deleteStudent(Student student){
        studentDao.delete(student);
    }

    public void showMenu(){
        System.out.println("Available Menu Items: ");
        System.out.println("1: Add Student");
        System.out.println("2: Update Student");
        System.out.println("3: Get Students");
        System.out.println("4: Delete Student"+"\n\n");
        System.out.println("Which function do you want to execute>");
        System.out.print("Menu Item: ");
    }
}
