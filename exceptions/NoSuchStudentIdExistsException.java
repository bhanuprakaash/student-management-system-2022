package exceptions;

public class NoSuchStudentIdExistsException extends RuntimeException{
    public NoSuchStudentIdExistsException(String studentId) {
        super(String.format("A Student with specified id %s does not exist!, Try valid student id", studentId));
    }
}
