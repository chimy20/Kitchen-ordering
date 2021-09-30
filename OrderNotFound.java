package OrderExceptions;

// Thrown when the order is not found
public class OrderNotFound extends Exception{
    public OrderNotFound(String message){
        super(message);
    }
}
