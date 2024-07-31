// 9.(L1)Write a program to illustrate how to throw a ClassNotFoundException.

class Task9
  {

  public void loadClass(String className) throws ClassNotFoundException
    {
        Class.forName(className);
        System.out.println("Class "+className+"loaded successfully");
    }

public static void main(String[] args)
  {
     Task9 example = new Task9();
      try 
	{
            
            example.loadClass("com.nonexistent.ClassName");
        }
    catch(ClassNotFoundException e) 
	{
            System.out.println("Class is Not Found: "+ e.getMessage());
        }

        System.out.println("Remaining TAsks");
    }
}
