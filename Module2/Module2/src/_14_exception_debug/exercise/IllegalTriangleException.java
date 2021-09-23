package _14_exception_debug.exercise;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}
