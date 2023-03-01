package dao;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentDao implements Dao<Student>{
    private List<Student> students = new ArrayList<>();
    @Override
    public Optional<Student> get(String id) {
        return students.stream()
                .filter(u -> id.equals(u.getStudentId()))
                .findFirst();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student, String[] params) {
        student.setStudentId(params[0]);
        student.setFirstName(params[1]);
        student.setLastName(params[2]);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }
}
