package OrderExceptions;

// Is thrown when an order is invalid
public class InvalidOrder extends Exception {
    public InvalidOrder(){
        super("Something went wrong with you'r order, please try again");
    }
}
