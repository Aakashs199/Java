/* (L3)Create a multi threaded program by creating a subclass of Thread and then creating,
 initializing, and staring two Thread objects from your class. The threads will execute concurrently 
and display Java is hot, aromatic, and invigorating to the console window. */

public class Task5 extends Thread
 {
   public Task5(String name) 
    {
      super(name);
    }

  public void run()
    {
       System.out.println(getName()+": Java is hot,aromatic,and invigorating");
    }

 public static void main(String[] args)
   {
     Thread thread1 = new Task5("Thread 1");
     Thread thread2 = new Task5("Thread 2");
     thread1.start();
     thread2.start();
    }
}
