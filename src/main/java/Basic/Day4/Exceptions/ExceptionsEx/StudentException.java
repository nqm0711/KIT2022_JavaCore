package Basic.Day4.Exceptions.ExceptionsEx;

public class StudentException extends Exception{
    public StudentException(String message){
        super(message);
    }
    public StudentException(String message, Throwable cause){
        super(message, cause);
    }
}