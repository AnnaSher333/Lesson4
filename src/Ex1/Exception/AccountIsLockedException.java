package Ex1.Exception;

public class AccountIsLockedException extends Exception{
private long startLock;
    public AccountIsLockedException(String message) {
        super(message);
    }

}
