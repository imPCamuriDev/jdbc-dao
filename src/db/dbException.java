package db;

public class dbException extends RuntimeException {
    private static final long serialVersionUUID = 1L;

    public dbException (String msg) {
        super(msg);
    }
}
