package db;

public class DbIntegrityException extends RuntimeException {
    private static final long serialVersionUUID = 1L;

    public DbIntegrityException(String message) {
        super(message);
    }
}
