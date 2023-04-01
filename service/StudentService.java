package service;

import dao.Dao;
import model.Student;
import exceptions.InvalidOptionException;

import java.util.Comparator;
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
        studentDao.add(student);
    }

    public void updateStudent(Student newValues){
        studentDao.update(newValues);
    }

    public void deleteStudent(String studentId){
        studentDao.delete(studentId);
    }

    public List<Student> sortStudents(int choice){
        switch (choice){
            case 1 -> {
                return studentDao.sortStudents(Comparator.comparing(Student::getStudentId));
            }
            case 2 -> {
                return studentDao.sortStudents(Comparator.comparing(Student::getFirstName));
            }
            case 3 -> {
                return studentDao.sortStudents(Comparator.comparing(Student::getLastName));
            }
            default ->{
                throw new InvalidOptionException(choice);
            }
        }
    }

}
