package _14_exception_debug.execrise;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}
