package exception;

public class InvalidDataException extends RuntimeException {

    private String message;
    private String errorCode;

    public InvalidDataException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
