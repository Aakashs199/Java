/* 3.Implement a Queue and perform the operations Insert, Delete, Update and Traverse */

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

public class QueueUsingLinkedList
 {
    static Node front=null;
    static Node rear=null;
    static Scanner sc=new Scanner(System.in);

public static void enQueue()
{
   System.out.println("Enter the Element to be Inserted: ");
   int value=sc.nextInt();
   Node newNode=new Node(value);
   if(newNode==null)
     {
	System.out.println("Not able to Push");
     }
   else
     {
 	if(front==null)
	  {
	    front=newNode;
	    rear=newNode;
	    front.next=null;
	    rear.next=null;
	   }
	else
	{
	  rear.next=newNode;
	  rear=newNode;
	  rear.next=null;	
	}
	System.out.println("Element Inserted");
     }
}

public static void deQueue()
{
  if(front==null)
   {
	System.out.println("UNDERFLOW");
   }
   else
   {
     Node ptr=front;
     int value=front.data;
     front=front.next;
     ptr=null;
      System.out.println("ELEMENT POPED: "+value);	
   }
}

public static void display()
{
  if(front==null)
   {
	System.out.println("No more Elemets is There");
   }
  else
   {
     System.out.println("Printing the Queue Elements");
     Node temp=front;
     while(temp!=null)
      {
	System.out.println(temp.data);
         temp=temp.next;
      }
   }
}


 public static void main(String[] args)
   {
     int choice = 0;
     System.out.println("--------Queue operations using linked list--------");
     while(choice != 4) 
	{
            System.out.println("Chose one from the below options");
            System.out.println("\n1.Enqueue\n2.DeQueue\n3.Display\n4.Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
            switch(choice)
	      {
                 case 1:
                    enQueue();
		    display();
		    System.out.println("------");
                    break;
                case 2:
                    deQueue();
		    display();
		    System.out.println("------");
                    break;
                case 3:
                    display();
		    System.out.println("------");
                    break;
		
                case 4:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
  }