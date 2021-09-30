package FileOperations;

import OrderExceptions.InvalidOrder;
import Order_Type.*;
import java.io.*;
import java.util.ArrayList;


public class ReadFile {
    // Declaration of variables
    String filename = "allOrders.ser";
    private ArrayList<OrderType> temp = new ArrayList<OrderType>();
    FileInputStream nf = null;
    ObjectInputStream ois = null;

    public ReadFile(){


    }

    // Function that returns an ArrayList type OrderType
    // The arrayList is what is stored on the file
    // It is what is returned
    public ArrayList<OrderType> read(){

        // Declare new FileInputStream and ObjectInputStream
        try{

            nf = new FileInputStream(filename);
            if(nf.available() > 0) {
                ois = new ObjectInputStream(nf);
                temp = (ArrayList<OrderType>) ois.readObject();
            }
        // Catch any possible error
        }catch(FileNotFoundException e){
            System.out.println("Sorry couldn't find the desired file");
        }catch(ClassNotFoundException e){
            System.out.println("sorry the file is empty");
        }catch(InvalidClassException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            // close the FileInputStream and the ObjectInputStream if opened
            try {
                if (nf != null) {
                    nf.close();
                }

                if (ois != null) {
                    ois.close();
                }
            }catch(IOException e){
                System.out.println("Sorry something went wrong");
            }
        }
        // Return the arrayList
        return temp;
    }
}
