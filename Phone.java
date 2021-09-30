package Order_Type;

public class Phone extends OrderType {
    private boolean toPickUp;
   public Phone(String name, String description){
        super(name, description, 3);
        this.toPickUp = false;
    }

    // set if it is ready to pickup
    public void markPickUp(){
        toPickUp = true;
    }

    // Get if it is ready to pick up
    boolean getPickUp(){
        return toPickUp;
    }

    // Basic information from the order, since this one is for pick up it has another variable that the other two dont
    @Override
    public String toString(){
       return "This order was posted by " + this.name + " by " + priority.getOrder() + ".\n"
               + "Order: " + this.description + ".\n"
               + "is currently cooking: " + this.currCooking + "\n"
               + "is complete: " + this.complete + "\n"
               + "is ready for pick up: " + this.toPickUp + "\n"
               + "is cancelled: " + this.cancelled + "\n"
               + this.time.toString();
    }
}
