/* 4.Implement a Stack and perform the operations Insert, Delete, Update and Traverse */

import java.util.*;
class Node
{
  Node next;
  int data;
   public Node(int data)
	{
	  this.data=data;
	  this.next=null;
	}
}

public class StackUsingLinkedList
 {
    static Node head = null;
    static Scanner sc = new Scanner(System.in);

public static void push()
{
   System.out.println("Enter the Element to be Pushed: ");
   int value=sc.nextInt();
   Node newNode=new Node(value);
   if(newNode==null)
     {
	System.out.println("Not able to Push");
     }
   else
     {
 	if(head==null)
	  {
	    head=newNode;
	  }
	else
	{
	  newNode.next=head;
	  head=newNode;
	}
     }
}

public static void pop()
{
  if(head==null)
   {
	System.out.println("UNDERFLOW");
   }
   else
   {
      int value=head.data;
      Node temp=head;
      head=head.next;
      temp=null;
      System.out.println("ELEMENT POPED: "+value);	
   }
}

public static void display()
{
  if(head==null)
   {
	System.out.println("No more Elemets is There");
   }
  else
   {
     System.out.println("Printing the Stack Elements");
     Node temp=head;
     while(temp!=null)
      {
	System.out.println(temp.data);
         temp=temp.next;
      }
   }
}

public static void peek()
{
  System.out.println("TOP MOST ELEMENT IS: "head.data);
}

 public static void main(String[] args)
   {
     int choice = 0;
     System.out.println("--------Stack operations using linked list--------");
     while(choice != 5) 
	{
            System.out.println("Chose one from the below options");
            System.out.println("\n1.Push\n2.Pop\n3.Show\n4.Peek\n5.Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
            switch(choice)
	      {
                 case 1:
                    push();
		    display();
		    System.out.println("------");
                    break;
                case 2:
                    pop();
		    display();
		    System.out.println("------");
                    break;
                case 3:
                    display();
		    System.out.println("------");
                    break;
		case 4:
		     peek();
		     System.out.println("------");
		     break;
                case 5:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
  }