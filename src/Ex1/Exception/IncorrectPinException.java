package Ex1.Exception;

public class IncorrectPinException extends Exception {
    public IncorrectPinException(String description) {
        super(description);
    }
}
