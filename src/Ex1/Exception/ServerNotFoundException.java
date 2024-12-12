package Ex1.Exception;

public class ServerNotFoundException extends Exception{
    public ServerNotFoundException(String description){
        super(description);
    }
}
