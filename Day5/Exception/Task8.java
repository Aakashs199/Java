/* 8.(L1)Write a program for creation of user defined exception. */

class InvalidAgeException extends Exception 
 {
    public InvalidAgeException(String message)
    {
        super(message);
    }
}

public class Task8
  {

    public void checkAge(int age) throws InvalidAgeException 
    {
        if(age<18) 
   	{
            throw new InvalidAgeException("Age must be 18 or above to vote");
        } 
	else 
	{
            System.out.println("Age is valid for voting");
        }
    }

public static void main(String[] args)
 {
        Task8 example=new Task8();
        try 
	{
            example.checkAge(16);
        }
	catch(InvalidAgeException e) 
	{
            System.out.println(e.getMessage());
        }

        try 
	{
            example.checkAge(20);
        }
	catch(InvalidAgeException e)
	 {
            System.out.println(e.getMessage());
         }

        System.out.println("Rest of the Program");
    }
}
