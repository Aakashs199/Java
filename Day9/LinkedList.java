 
/* 1.Implement a singly linked list and perform the operations Insert, Delete, Update and Traverse */


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


public class LinkedList
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


public static Node begInsert(Node head,int data)
{
  Node ptr=new Node(data);
  if(ptr==null)
   {
	System.out.println("OVER FLOW");
   }
   else
    {
      ptr.next=head;
      head=ptr;
      System.out.println("----	NODE INSERTED AT BEGINING-----");
    }
    return head;	
}


public static Node endInsert(Node head,int data)
{
  Node ptr=new Node(data);
  
   if(ptr==null)
    {
       System.out.println("OVER FLOW");
    }
   else if(head==null)
    {
       head=ptr;
       System.out.println("--------NODE INSERTED AT END---------");
     }
  else
   {
       Node current=head;
      while(current.next!=null)
        {
          current=current.next;
        }
      current.next=ptr;
      System.out.println("---------NODE INSERTED AT END---------");
   }
return head;
}



public static Node randomInsert(Node head,int data,int pos)
{
   Node ptr=new Node(data);
   if(ptr==null)
    {
      System.out.println("OVERFLOW");
    }
   else
     {
       if(pos==1)
	{
	  ptr.next=head;
          head=ptr;
	}
       else
 	{
	   Node temp=head;
	   for(int i=1;i<pos-1&&temp!=null;i++)
		{
		  temp=temp.next;
		}
	   if(temp==null)
		{
		   System.out.println("OUT OF RANGE INSERT POSITION");
		}
	   else
	 	{
		   ptr.next=temp.next;
		   temp.next=ptr;
		}
	}
    System.out.println("Node Inserted At the Position: "+pos);
     }
  return head;
}


public static Node deleteAtBegining(Node head)
 {
   if(head==null)
	{
	  System.out.println("List is Empty");
	}
   else
     {
        head=head.next;
        System.out.println("Node Deleted At begining");
     }
   return head;
 }


public static Node deleteAtEnd(Node head)
 {
   if(head==null)
	{
	  System.out.println("List is Empty");
	}
   else if(head.next==null)
	{
	   head=null;
	}
   else
     {
	Node temp=head;
	while(temp.next.next!=null)
	{
	   temp=temp.next;
	}
        temp.next=null;
        System.out.println("Node Deleted At End");
     }
   return head;
 }

public static Node randomDelete(Node head,int position)
{
   if(head==null)
     {
        System.out.println("List is empty");
     }
   else
     {
       if(position==1)
	 {
            head=head.next;
         }
       else
	{
	     Node temp=head;
	     for(int i=1;i<position-1 && temp!=null ;i++)
		{
		   temp=temp.next;
		}
	     if(temp==null || temp.next==null)
		{
		    System.out.println("Delete is Not Possible");
		}
             else
		{
		   temp.next=temp.next.next;
		}
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

public static Node updateElement(Node head,int value,int pos)
{
   if(head==null)
	{
	   System.out.println("List is Empty");
	}
   else
	{
	   Node temp=head;
	    for(int i=1;i<pos&&temp!=null;i++)
		{
		    temp=temp.next;
		}
	    if(temp==null)
		{
		  System.out.println("Position is Not Found");
		}
	   else
		{
 		    temp.data=value;
		    System.out.println("VALUE UPDATED");
		}
	}
  return head;
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

  while(true)
    {
      System.out.println("1-> Create Linked List");
      System.out.println("2-> Insert At Begining");
      System.out.println("3-> Insert At End");
      System.out.println("4-> Insert At any Position");
      System.out.println("5-> Delete At Begining");
      System.out.println("6-> Delete At End");
      System.out.println("7-> Delete At any Position");
      System.out.println("8-> Search An Element");
      System.out.println("9-> Display Linked List");
      System.out.println("10-> Update Element");
      System.out.println("11-> Exit Operations");

	System.out.print("Enter a Choice: ");
	int choice=sc.nextInt();

   switch(choice)
     {

 	case 1:
		   if(head==null)
		     {
		       head=createLinkedList();
	               System.out.println("------LinkedListCreated------");
		    }
		   else
		      {
			 System.out.println("Creation is Not Posiiable");
		      }

		   int len1=travereseLinkedList(head);
                   System.out.println("The length of the LinkedList is: "+len1);
	           break;

	case 2:
 		System.out.print("Enter a Value to Be Inserted at Begining: ");
		int item1=sc.nextInt();
		head=begInsert(head,item1);
		int len2=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len2);
		System.out.println("-----------------------------");
		System.out.println();
	 	break;

	case 3:
		System.out.print("Enter a Value to Be Inserted at End: ");
		int item2=sc.nextInt();
		head=endInsert(head,item2);
		int len3=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len3);
		System.out.println("-----------------------------");
		System.out.println();
		break;

	case 4:
		System.out.print("Enter a Value to Be Inserted: ");
		int item3=sc.nextInt();
		System.out.print("Enter a Position to Be Inserted: ");
		int pos=sc.nextInt();
		head=randomInsert(head,item3,pos);
		int len4=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len4);
		System.out.println("-----------------------------");
		System.out.println();
		break;

	case 5:
		head=deleteAtBegining(head);
		int len5=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len5);
		System.out.println("-----------------------------");
		System.out.println();
		break;

	case 6:
		head=deleteAtEnd(head);
		int len6=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len6);
		System.out.println("-----------------------------");
		System.out.println();
		break;
	
	case 7:
		System.out.print("Enter a Position to Be Deleted: ");
		int pos2=sc.nextInt();
		head=randomDelete(head,pos2);
		int len7=travereseLinkedList(head);
                System.out.println("The length of the LinkedList is: "+len7);
		System.out.println("-----------------------------");
		System.out.println();
		break;

	case 8:
		System.out.print("Enter a Value to Be Searched: ");
		int searchElement=sc.nextInt();
		search(head,searchElement);
		System.out.println("-----------------------------");
		System.out.println();
		break;

	case 9:
		 if(head!=null)
	              {  
			  int len=travereseLinkedList(head);
                          System.out.println("The length of the LinkedList is: "+len);
	 	         
	              }
		  else
			{
			   System.out.println("The Linked List is Empty");
			}
		   System.out.println("-----------------------------");
		   System.out.println();
		   break;

	case 10:
		    System.out.print("Enter the new item to update: ");
                    int newItem = sc.nextInt();
                    System.out.print("Enter the position to update: ");
                    int pos3 = sc.nextInt();
                    head=updateElement(head,newItem,pos3);
		   int len8=travereseLinkedList(head);
                   System.out.println("The length of the LinkedList is: "+len8);
	           System.out.println("-----------------------------");
		   System.out.println();
                    break;
		
 	 
	case 11:
		System.out.println("--------Exiting Program------------");
		System.out.println();
		break;

	default:
		System.out.println("Invalid choice");
		break;
     }
   if(choice==11)
	{
	    break;
	}
    }

     
       
  }
}