/* 6. (L1)Write a program to describe the usage of throws clause */


class Task6 
 {
    public void performOperation(int value) throws IllegalArgumentException 
      {
        if(value<0)
	 {
            throw new IllegalArgumentException("Negative value not allowed");
         }
        System.out.println("Operation performed successfully with value: "+value);
    }

public static void main(String[] args)
 {
        Task6 example=new Task6();

      try
	 {
            example.performOperation(-5);
        }
     catch(IllegalArgumentException e)
	 {
            System.out.println("Caught IllegalArgumentException: "+e.getMessage());
         }

        try
	 {
            example.performOperation(10);
         }
	 catch(IllegalArgumentException e) 
	{
            System.out.println("Caught IllegalArgumentException: "+e.getMessage());
        }

        System.out.println("Remaining Program");
    }
}
