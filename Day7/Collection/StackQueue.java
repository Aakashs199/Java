/*9. Make a searching, inserting,deleting and updating operation in Stack and Queue data structures. */

import java.util.*;
public class StackQueue
{
static void insert(Stack<Integer> stack,int n)
{
  stack.push(new Integer(n));
  System.out.println("Pushed Element -> "+n);
  System.out.println("Stack: "+stack);
}
public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);
 Stack<Integer> stack=new Stack<Integer>();
 System.out.println(stack);
 System.out.println(stack.empty());
 insert(stack,10);
 insert(stack,20);
 insert(stack,30);
 insert(stack,40);
 insert(stack,50);
 insert(stack,60);S
 stack.pop();
 stack.pop();
 System.out.println(stack);
 System.out.println("Searched Element at: "+stack.search(40));
 System.out.println("Top Element in Stack: "+stack.peek());
 System.out.println("The size of Stack: "+stack.size());
 System.out.println("Is the Stack is Empty?: "+stack.empty());

 System.out.println("----Queue Operations----");
 Queue<Integer> queue=new LinkedList<Integer>();
 for(int i=1;i<=10;i+=2)
  {
    queue.add(i);
   }
 System.out.println(queue);
 System.out.println("Removed element: "+queue.remove());
 System.out.println(queue);
  System.out.println("Top Element: "+queue.peek());
  System.out.println("The size of Queue: "+queue.size());
}
}