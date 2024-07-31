/* 2.Find the specific element in the Singly linked list */


import java.util.*;
class Node
{
  int data;
  Node next;
  public Node(int data)
   {
      this.data=data;
      this.next=null;
   }
}


public class LinkedListSearch

{
 static Scanner sc=new Scanner(System.in);
 static Node head=null;

 static Node createLinkedList()
   {	
        System.out.print("Enter the Number of Nodes: ");
	int n=sc.nextInt();
        if(n<=0)
         {
           System.out.println("Mo Nodes to be Created");
           return null;
         }
         System.out.println("Enter the Value for Nodes:");
	 Node head=null;
	 Node tail=null;
          for(int i=0;i<n;i++)
	    {
		int value=sc.nextInt();
		Node newNode=new Node(value);
		if(head==null)
		  {
		    head=newNode;
		    tail=newNode;
		  }
		else
		  {
		    tail.next=newNode;
		    tail=newNode;
		  }
	     }
   return head;
} 

public static void search(Node head,int value)
 {
    Node temp=head;
    int position=1;
    boolean found=false;
   while(temp!=null)
    {
       if(temp.data==value)
	{
	  System.out.println("Element "+value+" Found At Position: "+position);
	  found=true;
	  break;
	}
	temp=temp.next;
	position++;
    }
  if(!found)
   {
     System.out.println("Element "+value+" is Not Found");
   }
 }

public static int travereseLinkedList(Node head)
{
      Node current=head;
	int length=0;
       while(current!=null)
	{
	   System.out.print(current.data+"->");
           current=current.next;
	   length++;
	}
	System.out.println();
   return length;
}


public static void main(String args[])
  {
   head = createLinkedList();
    if(head!=null)
     {  
	 int len=travereseLinkedList(head);
         System.out.println("The length of the LinkedList is: "+len);
	 System.out.print("Enter a Value to Be Searched: ");
         int searchElement=sc.nextInt();
         search(head,searchElement);
      }
    else
	{
	   System.out.println("The Linked List is Empty");
	}
     
       
  }
}