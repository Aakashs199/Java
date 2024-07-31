/*(L2)Write a program to create a directory and check whether the directory is created. */

import java.io.File;
public class CreateDirectory 
{
    public static void main(String[] args)
 {
    String directoryName="newDirectory";
    File directory=new File(directoryName);
    boolean isCreated=directory.mkdir();
        if (isCreated) 
	{
           System.out.println("Directory "+directoryName+" created successfully");
        } 
	else
	 {
            System.out.println("Failed to create the directory "+directoryName+" It may already exist.");
         }
    }
}
