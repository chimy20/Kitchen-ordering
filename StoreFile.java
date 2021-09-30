package FileOperations;

import Order_Type.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class StoreFile {
    String filename = "allOrders.ser";
    FileOutputStream nf;
    ObjectOutputStream oos;

    public StoreFile(){

    }

    public void writeFile(ArrayList<OrderType> x){
        // Declare variables
        nf = null;
        oos = null;

        //Open FileOutputStream and ObjectOutputStream and write the ArrayList on the file
        try{
            nf = new FileOutputStream(filename);
            oos = new ObjectOutputStream(nf);
            oos.writeObject(x);
            System.out.println("Saved");
         // catch any possible errors
        }catch(FileNotFoundException e){
            System.out.println("Sorry, the file was not found");
        }catch(IOException e){
            System.out.println("Sorry, the something went wrong with the output streem");
            e.printStackTrace();

        }finally{
            //Finally if the file was succesfully opened and the data retieved, close them
            if(nf != null){
                try{
                    nf.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(oos != null){
                try{
                    oos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }




}
