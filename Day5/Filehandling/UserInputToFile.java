/* (L2)Write a program to get the input from the user and store it into file. Using Reader and Writer file. */



import java.io.*;
public class UserInputToFile 
  {
    public static void main(String[] args)
     {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer=new BufferedWriter(new FileWriter("userInput.txt")))
        {

            System.out.println("Enter text (type 'exit' to finish):");
            String inputLine;
              while(!(inputLine = reader.readLine()).equalsIgnoreCase("exit"))
              {
                writer.write(inputLine);
                writer.newLine();
              }
        } 
   catch (IOException e) 
     {
       System.err.println("An error occurred: " + e.getMessage());
     }
  }
}
