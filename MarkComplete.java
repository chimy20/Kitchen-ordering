package OrderExceptions;

// Is thrown when an order has been attempted to mark as complete without being marked as currently cooking
public class MarkComplete extends Exception {
    public MarkComplete(){
        super("The order must be set to start cooking before being completed. \n Pleas try again");
    }
}
