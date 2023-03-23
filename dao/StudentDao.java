package dao;

import exceptions.NoSuchStudentIdExistsException;
import exceptions.StudentIdAlreadyExistsException;
import model.Student;

import java.util.ArrayList;
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
    public void save(Student student) throws StudentIdAlreadyExistsException {
        if (students.stream().anyMatch(u -> student.getStudentId().equals(u.getStudentId()))) {
            throw new StudentIdAlreadyExistsException(student.getStudentId());
        }
        students.add(student);
    }

    @Override
    public void update(Student newValues) throws NoSuchStudentIdExistsException{
        if (students.stream().noneMatch(u -> newValues.getStudentId().equals(u.getStudentId()))) {
            throw new NoSuchStudentIdExistsException(newValues.getStudentId());
        }
        students.stream()
                .filter(u -> newValues.getStudentId().equals(u.getStudentId()))
                .findFirst()
                .ifPresent(u -> {
                    u.setFirstName(newValues.getFirstName());
                    u.setLastName(newValues.getLastName());
                });
    }

    @Override
    public void delete(String studentId)  {
        students.remove(get(studentId));
    }
}
