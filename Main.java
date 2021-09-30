
/*
This project was done by Nadim Kayali and Chimere Onyegbado.
The purpose of this programme is to create an efficient ordering and management system for a restaurant.
This system is target to only the staff of the restaurant.
We designed this programme understanding with the believe that the staff is able to cook more than one order at a time.
Each order has a priority. To ensure that all orders are prepared, only 3 orders of a higher priority are able to pass
one of lower priority.

The system we designed has input validation.
The next order not currently being prepared will be the next one to go.
An order can only be mark as complete if it is being prepared beforehand.
Only phone and online ordering are available for pick up after completed.
An order can only be canceled if it is not currently being prepared.
After an order has been completed it will be removed from the queue. If it is due for pickup, it will be set so and await a pick up.



 */

// Packages imported
package com.company;
import FileOperations.*;
import Order_Type.DriveThrough;
import Order_Type.Onsite;
import Order_Type.Phone;
import Queues.MainQueue;
import OrderExceptions.OrderNotFound;
import OrderExceptions.InvalidOrder;
import java.util.*;

import Order_Type.*;


public class Main {
    public static void main(String[] args) {

        // Declare variables and classes
        boolean isEnd = false;
        String userName = null;
        String order = null;
        int choice = 0;

        ArrayList<OrderType> allOrders;
        MainQueue mainList = new MainQueue();
        MainQueue pickuplist = new MainQueue();
        LinkedList<DriveThrough> drive = new LinkedList<DriveThrough>();
        LinkedList<Phone> phone = new LinkedList<Phone>();
        LinkedList<Onsite> onsite = new LinkedList<Onsite>();
        LinkedList<Online> online = new LinkedList<Online>();

        Scanner input = new Scanner(System.in);

        // Retrieve previous loads of all orders
        // declare a ReadFile class
        ReadFile rl = new ReadFile();
        // Set the array list from the saved file to the allOrders arrayList
        allOrders = (ArrayList<OrderType>) rl.read();

        do {

            // User interface display
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Select an action to perform");
            System.out.println("1.Place an order");
            System.out.println("2.Get the next order that is not currently cooking");
            System.out.println("3.Get details regarding all orders being currently cooked");
            System.out.println("4.Mark a current order as complete");
            System.out.println("5.List all order waiting to be picked up");
            System.out.println("6.List all orders");
            System.out.println("7. Mark an Order as currently cooking");
            System.out.println("8. Pick up an order");
            System.out.println("9.Cancel an order, only if it is not currently cooking");
            System.out.println("10.Exit program");
            System.out.print(">>");

            // Function selection by user
            // User input and validation
            try{
                choice = input.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Sorry, not valid input. Please try a number in between 1 and 9");
                input.nextLine();
                System.out.print(">>");
                choice = input.nextInt();

            }

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\n\n\n");


                switch (choice) {
 // ----------------------------------------------------------------------------------------------------------------------
                    case 1:
                        //Display user interface to choose a type of order
                        int i = 0;
                        System.out.println("What's the order type?");
                        System.out.println("1.Drive-through");
                        System.out.println("2.Onsite");
                        System.out.println("3.Phone");
                        System.out.println("4.Online");
                        System.out.print(">>");

                        // User input and validation
                        try {
                            i = input.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("Sorry, not valid input. Please try a number in between 1 and 4");
                            input.nextLine();
                            System.out.print(">>");
                            i = input.nextInt();
                        }

                        switch (i) {
// ====================================================================================================
                            // Order type 1: Drive through;
                            case 1:

                                System.out.println("Enter your name");
                                System.out.print(">>");
                                userName = input.next();

                                // User input and validation
                                if (input.hasNextLine()) {
                                    userName = userName + input.nextLine();
                                }

                                System.out.println("Enter the order description");
                                System.out.print(">>");
                                order = input.next();

                                // User input and validation
                                if (input.hasNextLine()) {
                                    order = order + input.nextLine();
                                }
                                // if the input is valid, create the order and add them to main queue, its own orderType list
                                // and to all the orders
                                try {
                                    if (userName != null && order != null) {
                                        DriveThrough or = new DriveThrough(userName, order);
                                        mainList.addQueue(or);
                                        drive.add(or);
                                        allOrders.add(or);
                                    } else {
                                        throw new InvalidOrder();
                                    }
                                } catch (InvalidOrder e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

// ====================================================================================================
                            // Order Type 2: On site
                            case 2:
                                System.out.println("Enter your name");
                                System.out.print(">>");
                                userName = input.next();

                                // User input and validation
                                if (input.hasNextLine()) {
                                    userName = userName + input.nextLine();
                                }

                                System.out.println("Enter the order description");
                                System.out.print(">>");
                                order = input.next();

                                // User input and validation
                                if (input.hasNextLine()) {
                                    order = order + input.nextLine();
                                }

                                // if the input is valid, create the order and add them to main queue, its own orderType list
                                    // and to all the orders
                                try {
                                    if (userName != null && order != null) {
                                        Onsite or1 = new Onsite(userName, order);
                                        mainList.addQueue(or1);
                                        onsite.add(or1);
                                        allOrders.add(or1);
                                    } else {
                                        throw new InvalidOrder();
                                    }
                                } catch (InvalidOrder e) {
                                    System.out.println(e.getMessage());
                                }

                                break;

// ====================================================================================================
                            // Order Type 3: Phone
                            case 3:
                                System.out.println("Enter your name");
                                System.out.print(">>");
                                userName = input.next();

                                if (input.hasNextLine()) {
                                    userName = userName + input.nextLine();
                                }

                                System.out.println("Enter the order description");
                                System.out.print(">>");
                                order = input.next();

                                if (input.hasNextLine()) {
                                    order = order + input.nextLine();
                                }

                                // if the input is valid, create the order and add them to main queue, its own orderType list
                                // and to all the orders
                                try {
                                    if (userName != null && order != null) {
                                        Phone or2 = new Phone(userName, order);
                                        mainList.addQueue(or2);
                                        phone.add(or2);
                                        allOrders.add(or2);
                                    } else {
                                        throw new InvalidOrder();
                                    }
                                } catch (InvalidOrder e) {
                                    System.out.println(e.getMessage());
                                }

                                break;

// ====================================================================================================
                            // Order Type 4: Online
                            case 4:
                                System.out.println("Enter your name");
                                System.out.print(">>");
                                userName = input.next();

                                if (input.hasNextLine()) {
                                    userName = userName + input.nextLine();
                                }

                                System.out.println("Enter the order description");
                                System.out.print(">>");
                                order = input.next();

                                if (input.hasNextLine()) {
                                    order = order + input.nextLine();
                                }

                                // if the input is valid, create the order and add them to main queue, its own orderType list
                                // and to all the orders
                                try {
                                    if (userName != null && order != null) {
                                        Online or3 = new Online(userName, order);
                                        mainList.addQueue(or3);
                                        online.add(or3);
                                        allOrders.add(or3);
                                    } else {
                                        throw new InvalidOrder();
                                    }
                                } catch (InvalidOrder e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
// ====================================================================================================
                        }
                        break;

// ----------------------------------------------------------------------------------------------------------------------
// GET THE NEXT ORDER TO COOK
                    case 2:
                        // Iterate through all the orders and display the next to the last one that is already currently cooking
                        OrderType temp = null;
                        for (int w = 0; w < mainList.getSize(); w++) {
                            if (!mainList.getElementbyIndex(w).isCurrCooking()) {
                                temp = mainList.getElementbyIndex(w);
                                break;
                            }
                        }

                        // If there is no order to cook
                        try {
                            if (temp != null) {
                                System.out.println(temp.toString());
                            } else {
                                throw new OrderNotFound("There are no orders to cook");
                            }
                        } catch (OrderNotFound e) {
                            System.out.println(e.getMessage());
                        }

                        break;


// ----------------------------------------------------------------------------------------------------------------------
// GET DETAILS From all the orders that are currently cooking
                    case 3:
                        //Display all orders that are currently cooking
                        int r;
                        int count = 0;
                        for (r = 0; r < mainList.getSize(); r++) {
                            if (mainList.getElementbyIndex(r).isCurrCooking()) {
                                System.out.println("Order number: " + r);
                                System.out.println(mainList.getElementbyIndex(r).toString());
                                count++;
                            }
                        }

                        // if there are no orders cooking
                        if(count == 0){
                            System.out.println("There are no orders currently cooking, please mark an order to cook");
                        }
                        break;


// ----------------------------------------------------------------------------------------------------------------------
// MARK A CURRENTLY COOKING ORDER AS COMPLETE
                    case 4:
                        // Display all ordes currently cooking
                        boolean isCurrCooking = false;
                        int c = -1;
                        int s;
                        for (s = 0; s < mainList.getSize(); s++) {
                            if (mainList.getElementbyIndex(s).isCurrCooking()) {
                                System.out.println("Order # " + s);
                                System.out.println(mainList.getElementbyIndex(s).toString());
                            }
                        }

                        // If there are orders cooking, select which one to mark as complete
                        if(s != 0) {
                            System.out.println("Please enter an order");
                            System.out.print(">>");
                            c = input.nextInt();

                            // User input validation
                            try {
                                // if out of bunds
                                if (c > mainList.getSize() || c < 0) {
                                    throw new IndexOutOfBoundsException();

                                    // if the chosen order is not currently cooking
                                } else if (!mainList.getElementbyIndex(c).isCurrCooking()) {
                                    throw new InvalidOrder();

                                    // If it is due for pick up
                                } else if (mainList.getElementbyIndex(c) instanceof Phone || mainList.getElementbyIndex(c) instanceof Online) {
                                    mainList.markAsComplete(mainList.getElementbyIndex(c));
                                    pickuplist.addQueue(mainList.getElementbyIndex(c));
                                    System.out.println("The order has been added to the pick up list");
                                    System.out.println("The order has been marked as complete and removed from the list");
                                    mainList.removeElementIndex(c);

                                    // If it is not pick up
                                } else {
                                    mainList.markAsComplete(mainList.getElementbyIndex(c));
                                    mainList.removeElementIndex(c);
                                    System.out.println("The order has been marked as completed and removed from the list");

                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Sorry, there is no order for such index");

                            } catch (InvalidOrder e) {
                                System.out.println("Sorry, the order you have chosen is not currently being cooked");

                            }
                        }else{
                            System.out.println("Sorry no orders are currently cooking");

                        }

                        break;



// ----------------------------------------------------------------------------------------------------------------------
// LIST ALL ORDERS WAITING TO BE PICKED UP
                    case 5:
                        // Display all orders waiting to be picked up
                        int j;
                        int size = pickuplist.getSize();
                        for (j = 0; j < size; j++) {
                            System.out.println("Order to be picked up number " + j);
                            System.out.println(pickuplist.getElementbyIndex(j).toString());
                        }
                        // If there are no orders
                        if(j == 0){
                            System.out.println("Sorry, no orders available to pick up");
                        }
                        break;


// ----------------------------------------------------------------------------------------------------------------------
// LIST ALL ORDERS OF THE DAY
                    case 6:
                        // User interface displaying the options from where to chose
                        int pic;
                        System.out.println("Please choose");
                        System.out.println("1. Current queue of the day");
                        System.out.println("2. All overall orders");
                        System.out.print(">>");

                        // User input validation
                        try{
                            pic = input.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("Sorry, not valid input. Please try a number in between 1 or 2");
                            input.nextLine();
                            System.out.print(">>");
                            pic = input.nextInt();
                        }

                        switch(pic){
// ====================================================================================================
                            // Display all the orders from today
                            case 1:
                                int u;
                                for (u = 0; u < mainList.getSize(); u++) {
                                        System.out.println("============================");
                                        System.out.println("Order # " + u);
                                        System.out.println(mainList.getElementbyIndex(u).toString());
                                }
                                // If there are no orders
                                if(u == 0){
                                    System.out.println("Sorry, there are no current orders in the queue");
                                }
                                break;

// ====================================================================================================
                            //Display all the orders saved and currently posted
                            case 2:
                                int x = 0;
                                for (OrderType el : allOrders) {
                                    System.out.println("============================");
                                    System.out.println("Order index " + x);
                                    System.out.println(el.toString());
                                    x++;
                                }
                                // If there are no orders
                                if(x == 0){
                                    System.out.println("Sorry, no orders available");
                                }
                                break;

// ====================================================================================================
                        }

                        break;


// ----------------------------------------------------------------------------------------------------------------------
// Mark an order as currently cooking
                    case 7:
                        int cuenta = 0;
                        // Iterate through all the orders and display and mark as currently cooking the next one to the last one that was currently cooking
                        for (int z = 0; z < mainList.getSize(); z++) {
                            if (!mainList.getElementbyIndex(z).isCurrCooking()) {
                                mainList.getElementbyIndex(z).setCurrCooking();
                                System.out.println(mainList.getElementbyIndex(z).toString());
                                cuenta++;
                            }
                        }
                        // If there are no orders left
                        if(cuenta == 0){
                            System.out.println("Sorry, there are no orders currently cooking");
                        }else{
                            System.out.println("The next order has been set to start cooking");
                        }

                        break;

// ----------------------------------------------------------------------------------------------------------------------
// PICK UP AN ORDER BY INDEX
                    case 8:
                        //Display all orders waiting to be picked up
                        int pick;
                        int q;
                        for (q = 0; q < pickuplist.getSize(); q++) {
                            System.out.println(pickuplist.getElementbyIndex(q).toString());
                            System.out.println();
                        }

                        // If there are no orders
                        if(q == 0){
                            System.out.println("Sorry, no orders available to pick up");
                        }else {
                         // else choose from the orders displayed
                            System.out.println("\n Please choose from an order: ");
                            System.out.print(">>");
                            pick = input.nextInt();
                            // Validate user input and pick up if
                            try {
                                if (pick < 0 && pick > q) {
                                    throw new IndexOutOfBoundsException();
                                } else {
                                    pickuplist.removeElementIndex(pick);
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Sorry, please choose an existing order");
                            }
                        }
                        break;


// ----------------------------------------------------------------------------------------------------------------------
// CANCEL AN ORDER ONLY IF IT IS NOT CURRENTLY COOKING
                    case 9:
                        // Iterate and display all orders from today
                        int p;
                        int a;
                        for (a = 0; a < mainList.getSize(); a++) {
                            System.out.println("Order #" + a);
                            System.out.println(mainList.getElementbyIndex(a).toString());
                            System.out.println();
                        }

                        // If there are no orders
                        if(a == 0){
                            System.out.println("Sorry, no orders available to cancel");
                        }else {
                        // else, choose one from the list
                            System.out.println("\n Please choose from an order to cancel: ");
                            System.out.print(">>");
                            p = input.nextInt();

                            // user input validation
                            try {
                                if (a < 0 && p > a) {
                                    throw new IndexOutOfBoundsException();
                                } else if (!mainList.getElementbyIndex(p).isCurrCooking()) {
                                    // else if it is not already currently cooking, set as cancelled and remove from the list
                                    mainList.getElementbyIndex(p).setCancelled();
                                    mainList.removeElementIndex(p);
                                    System.out.println("The order has been removed");
                                } else {
                                    System.out.println("Sorry, the order is currently being prepared");
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Sorry, please choose an existing order");
                            }
                        }

                        break;

// ----------------------------------------------------------------------------------------------------------------------
// Exit the loop
                    case 10:
                        isEnd = true;
                        break;

                    default:
                        System.out.println("Sorry, not valid input. Please try a number in between 1 and 9");
                        break;
                }

                System.out.println("\n \n");



        }while (!isEnd);


        // Rewrite the file with all the orders
        // Create a class of store file
        StoreFile newFile = new StoreFile();
        //write allOrders array list into the file
        newFile.writeFile(allOrders);
        System.out.println("All saved");
        System.exit(0);
    }

}