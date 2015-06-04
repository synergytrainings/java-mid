package pavel.midtraining.exception;

/**
 * Class represents persistence layer specific exception
 * Thrown by the persistence provider when a problem occur
 */
public class PersistenceException extends RuntimeException {

    private int resourceId;

    public PersistenceException() {
        super();
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String message, int resourceId) {
        super(message);
        this.resourceId = resourceId;
    }

    public PersistenceException(String message, Throwable cause, int resourceId) {
        super(message, cause);
        this.resourceId = resourceId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " \"" + resourceId + "\" id";
    }

    public int getResourceId() {
        return resourceId;
    }
}
