/*6. (L3)Create a multi threaded program as in the previous exercise by creating the MyThread subclass of Thread.
 But create threads as objects of the class MyClass, which is not a subclass of Thread. MyClass will implement the runnable 
interface and objects of MyClass will be executed as threads by passing them as arguments to the Thread constructor. */

class MyClass implements Runnable
 {
    private String threadName;
    public MyClass(String threadName)
     {
        this.threadName = threadName;
     }

 public void run()
   {
     for(int i=0;i<5;i++)
       {
          System.out.println(threadName+" - Count: "+i);
            try {
                   Thread.sleep(1000);
                } 
	    catch(InterruptedException e)
		 {
                    System.out.println(e);
                }
        }
        System.out.println(threadName+" exiting");
    }
}

public class Task6
 {
   public static void main(String[] args)
    {
       MyClass myClass1 = new MyClass("Thread-1");
       MyClass myClass2 = new MyClass("Thread-2");

       Thread thread1 = new Thread(myClass1);
       Thread thread2 = new Thread(myClass2);

       thread1.start();
       thread2.start();
    }
}
