package app.exceptions;

public class UserUpdateConflictException extends RuntimeException {
    public UserUpdateConflictException(String message) {
        super(message);
    }
}