/* (L1)Write a program to create a text file in the path c:\java\abc.txt and check whether that file is exists.
Using the command exists(), isDirectory(), isFile(), getName() and getAbsolutePath(). */

import java.io.*;
public class Fileexists
 {
  public static void main(String[] args) 
    {
        String filePath = "C:/Users/inc5540-12/Documents/Day5/Filehandling/abc.txt";
        File newFile = new File(filePath);
        
        try 
	{
           boolean fileCreated = newFile.createNewFile();    
            if(fileCreated) 
	    {
                System.out.println("File is created successfully");
            } 
	    else 
	     {
              System.out.println("File already exists.");
            }
            System.out.println("Exists: "+newFile.exists());
            System.out.println("Is Directory: "+newFile.isDirectory());
            System.out.println("Is File: "+newFile.isFile());
            System.out.println("File Name: "+newFile.getName());
            System.out.println("Absolute Path: "+newFile.getAbsolutePath());
            
        } 
  catch(IOException e)
     {
         System.out.println("Error occurred: "+e.getMessage());
     }
   }
}
