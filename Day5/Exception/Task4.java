// 4.(L2)Write a program to illustrate sub class exception precedence over base class.

class Base extends Exception 
{
    public Base(String message) 
    {
        super(message);
    }
}

class Sub extends Base
 {
    public Sub(String message) 
    {
        super(message);
    }
}

public class Task4 
{
  public static void main(String[] args)
   {
     try
	 {   
            boolean valid=true;
            if(valid) 
	    {
               throw new Sub("This is a SubException");
            } 
	    else
	    {
                throw new Base("This is a BaseException");
            }
        }
    catch(Sub e)
	{
          System.out.println("Caught SubException: "+e.getMessage());
        } 
    catch(Base e) 
	{
          System.out.println("Caught BaseException: "+e.getMessage());
        }
    }
}
