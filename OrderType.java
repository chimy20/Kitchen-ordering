package Order_Type;
import OrderExceptions.*;

import java.io.Serializable;
import java.util.Date;
import java.time.*;

abstract public class OrderType implements Serializable {
    // Declare basic variables for an order
    protected String name;
    protected Date time;
    protected String description;
    private int passedOrders = 0;
    protected boolean complete = false;
    protected boolean currCooking = false;
    protected Priority priority;
    protected boolean cancelled = false;

    // Initialize variables and get the priority
    OrderType(String name, String description, int p) {
        this.name = name;
        this.description = description;
        this.time = new Date();
        switch (p) {
            case 1:
                this.priority = Priority.DRIVETHROUGH;
                break;
            case 2:
                this.priority = Priority.ONSITE;
                break;
            case 3:
                this.priority = Priority.PHONE;
                break;
            case 4:
                this.priority = Priority.ONLINE;
                break;
        }
    }

    // GET if Complete
    public boolean isComplete() {
        return complete;
    }

    // GET if it is currently cooking
    public boolean isCurrCooking() {
        return currCooking;
    }

    // get its priority
    public int getPriority() {
        return priority.getPriority();
    }

    // Get name
    public String getName() {
        return this.name;
    }

    // Mark as complete
    public void markComplete() throws MarkComplete {
        // check if it is curr cooking
        if (currCooking) {
            complete = true;
            // if not throw MarkComplete exception
        } else {
            throw new MarkComplete();
        }

    }

    // Count the orders that have passed this order
    public void passOrder() {
        passedOrders += 1;
    }

    //Get how mnay orders have passed it already
    public int getPassedOrders() {
        return passedOrders;
    }

    //Set the order as currently cooking
    public void setCurrCooking() {
        if (complete) {
            currCooking = false;
        } else {
            currCooking = true;
        }
    }

    //Set the order as cancelled
    public void setCancelled(){
        this.cancelled = true;
    }



    // Basic information from the order
    @Override
    public String toString() {
        return "This order was posted by " + this.name + " by " + priority.getOrder() + ".\n"
                + "Order: " + this.description + ".\n"
                + "is currently cooking: " + this.currCooking + "\n"
                + "is complete: " + this.complete + "\n"
                + "is cancelled: " + this.cancelled + "\n"
                + this.time.toString();
    }

}



// Different types of priority
enum Priority{
    // Highest to lowest priority
    DRIVETHROUGH(1, "Drive Through"),
    ONSITE(2, "Onsite"),
    PHONE(3, "Phone"),
    ONLINE(4, "Online");


    private int priority;
    private String order;

    // Constructor initializing the variables
    Priority(int p, String x){
        this.priority = p;
        this.order = x;
    }

    // Get the priority
    int getPriority(){
        return this.priority;
    }

    // Get the type of Order
    String getOrder(){
        return this.order;
    }

}
