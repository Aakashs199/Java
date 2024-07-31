/* (L2)Write a program to create a file and write data into it using the methods OutputStream class. */

import java.io.*;
public class WriteToFileUsingOutputStream
   {
    public static void main(String[] args)
     {
       String data = "Hello World";
        try(OutputStream outputStream = new FileOutputStream("output.txt")) 
          {
            byte[] dataBytes = data.getBytes();
            outputStream.write(dataBytes);
            System.out.println("Data written to file successfully!");
         } 
catch (IOException e) 
   {
      System.err.println("An error occurred: " + e.getMessage());
    }
 }
}
