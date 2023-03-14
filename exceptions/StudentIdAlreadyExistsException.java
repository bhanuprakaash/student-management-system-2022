package exceptions;

public class StudentIdAlreadyExistsException extends RuntimeException{
    public StudentIdAlreadyExistsException(String studentId) {
        super(String.format("A Student with specified id %s already exists!", studentId));
    }
}
