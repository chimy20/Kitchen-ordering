package Order_Type;

public class Online extends OrderType {
    private boolean toPickUp;
   public Online(String name, String description){
        super(name, description, 4);

        this.toPickUp = false;

    }

    // Mark the order for pick up
    public void markPickUp(){
        toPickUp = true;
    }

    // Check if it has been picked up
   public boolean getPickUp(){
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
