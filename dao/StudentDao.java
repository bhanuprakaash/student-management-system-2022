package dao;

import exceptions.NoSuchStudentIdExistsException;
import exceptions.StudentIdAlreadyExistsException;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class StudentDao implements Dao<Student>{
    private final List<Student> students = new ArrayList<>();
    @Override
    public Student get(String id){
        return students.stream()
                .filter(u -> id.equals(u.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchStudentIdExistsException(id));
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void add(Student student) throws StudentIdAlreadyExistsException {
        students.stream()
                .filter(u -> student.getStudentId().equals(u.getStudentId()))
                .findFirst()
                .ifPresentOrElse(u -> {
                    throw new StudentIdAlreadyExistsException(student.getStudentId());
                },()->{
                    students.add(student);
                });
    }

    @Override
    public void update(Student newValues) throws NoSuchStudentIdExistsException{
        students.stream()
                .filter(u -> newValues.getStudentId().equals(u.getStudentId()))
                .findFirst()
                .ifPresentOrElse(u -> {
                    u.setFirstName(newValues.getFirstName());
                    u.setLastName(newValues.getLastName());
                },()->{
                    throw new NoSuchStudentIdExistsException(newValues.getStudentId());
                });
    }

    @Override
    public void delete(String studentId)  {
        students.remove(get(studentId));
    }

    @Override
    public List<Student> sortStudents(Comparator<Student> by) {
        return students.stream().sorted(by).toList();
    }
}
