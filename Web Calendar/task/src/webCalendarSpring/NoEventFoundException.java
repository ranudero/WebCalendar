package webCalendarSpring;

public class NoEventFoundException extends RuntimeException {
    public NoEventFoundException() {
    }

    public NoEventFoundException(String message) {
        super(message);
    }

    public NoEventFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEventFoundException(Throwable cause) {
        super(cause);
    }

    public NoEventFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
