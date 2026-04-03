package Exception;

public class DuplicateRegistrationException extends Exception{

    public DuplicateRegistrationException() {}

    public DuplicateRegistrationException(String message)
    {
        super(message);
    }
}
