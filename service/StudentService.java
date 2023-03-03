package service;

import dao.Dao;
import model.Student;


import java.util.List;

public class StudentService {
    private final Dao<Student> studentDao;

    public StudentService(Dao<Student> studentDao){
        this.studentDao = studentDao;
    }

    public Student getStudentById(String id){
        return studentDao.get(id);
    }

    public List<Student> getAllStudents(){
        return studentDao.getAll();
    }

    public void addStudent(Student student){
        studentDao.save(student);
    }

    public void updateStudent(Student newValues){
        studentDao.update(newValues);
    }

    public void deleteStudent(String studentId){
        studentDao.delete(studentId);
    }

    public void showMenu(){
        System.out.println("Available Menu Items: ");
        System.out.println("1: Add Student");
        System.out.println("2: Update Student");
        System.out.println("3: Get Students");
        System.out.println("""
                4: Delete Student

                """);
        System.out.println("Which function do you want to execute>");
        System.out.print("Menu Item: ");
    }
}
