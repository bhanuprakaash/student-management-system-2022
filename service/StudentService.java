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

    public List<Student> sortStudentsById(){
        return studentDao.sortStudentsById();
    }

    public List<Student> sortStudentsByFirstName(){
        return studentDao.sortStudentsByFirstName();
    }

    public List<Student> sortStudentsByLastName(){
        return studentDao.sortStudentsByLastName();
    }

}
