package exception;

public class GenericException extends RuntimeException {

    private String message;
    private String errorCode;

    public GenericException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
