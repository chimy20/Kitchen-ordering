package Queues;
import OrderExceptions.MarkComplete;
import Order_Type.DriveThrough;
import Order_Type.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MainQueue{
   LinkedList<OrderType> MainList = new LinkedList<OrderType>();

    // Priority functions
    /*
    Drive through, Onsite, Phone and Online.

    An order of lower priority is to be skipped by a higher priority order of a maximum
    of 3 orders. Afterwards this order needs to be complete.

     */

    // Add the order too last
    // if the previous order does not have 3 passed in front and it has a lower priority
    // move the order once and add a passed order to the passed order
    // keep going until it reaches an order that has been passed by 3 other order of higher priority

    // This function checks the priority of the order
    private void checkPriority(OrderType x){
        int i = 0;
        OrderType nextElement;

        i = MainList.indexOf(x);
        // checks if it is the first order
        if(i != 0) {
            // If it is not get the previous element and check if its priority is lower and how many times it has been previously passed
            nextElement = MainList.get(i - 1);
            if ((nextElement.getPriority() > x.getPriority()) && (nextElement.getPassedOrders() < 3)) {
                // If so, increase the count of passed orders for the previous element
                nextElement.passOrder();
                // Remove the element that has higher priority
                MainList.remove(i);
                // Add the element that has been just removed to the position of the element it was comparing with
                MainList.add(i - 1, x);
                // Call the function again untill it can advance no more
                checkPriority(x);
            }
        }

    }




    // Basic Queue Operations


    // Add an element to the list
    public void addQueue(OrderType x){
        MainList.add(x);
        checkPriority(x);
    }

    // Get the first order of the queue
    public OrderType getFirstOrder(){
        return MainList.getFirst();
    }

    // Remove an element from the list by index
   public void removeElementIndex(int index){
        MainList.remove(index);
    }


    // Get an element from the list
    public OrderType getElement(OrderType x){
        OrderType el = null;
        int i = MainList.indexOf(x);
        System.out.println(i);
        return MainList.get(i);

    }

    // Get element by index
    public OrderType getElementbyIndex(int x){
        return MainList.get(x);
    }


    // Mark an order as complete
   public void markAsComplete(OrderType x){
        // Mark as complete
           try {
               x.markComplete();
           }catch(MarkComplete e){
               System.out.println(e.getMessage());
           }


    }

     //get size of the list
    public int getSize(){
        return MainList.size();
    }


}

