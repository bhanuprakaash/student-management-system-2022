package exceptions;

public class InvalidOptionException extends RuntimeException{
    public InvalidOptionException(int option) {
        super(String.format("Invalid option %d, Try valid option", option));
    }
}