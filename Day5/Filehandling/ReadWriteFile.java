/* (L1)Write a program to show how to read and write a file. */

import java.io.*;
import java.util.Scanner;
public class ReadWriteFile
 {
    public static void main(String[] args)
     {
        try
          {
            File obj = new File("Myfiles.txt");
            Scanner read = new Scanner(obj);
            while (read.hasNextLine())
              {
                String data = read.nextLine();
                System.out.println(data);
               }
            read.close();
            FileWriter write = new FileWriter(obj);
            for (int i = 0; i < 5; i++) 
                {
                write.write("Line: "+i+"\n");
                }

            
            write.close();
        } 
         catch (FileNotFoundException e) 
            {
            System.out.println("File not found");
            }
        catch (IOException e) 
            {
            System.out.println("Error writing to file");
            }
    }
}
