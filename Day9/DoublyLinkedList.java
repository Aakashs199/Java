/* 5.Implement a Doubley linked list and perform the operations Insert, Delete, Update and Traverse */

import java.util.*;
class Node
{
  int data;
  Node next;
  Node prev;
   public Node(int data)
     {
	this.data=data;
	this.next=null;
	this.prev=null;
     }
}


public class DoublyLinkedList
{
 static Scanner sc=new Scanner(System.in);
 static Node head=null;

public static Node createDoubleyLinkedList()
  {
   System.out.print("Enter the Number of Nodes: ");
   int n=sc.nextInt();
   if(n<0)
    {
	System.out.println("List can't be Created ");
	return null;
    }
   System.out.println("Enter the Number of Values");
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
	  newNode.prev=tail;
	  tail=newNode;
	}
    }
   return head;
  }

public static Node insertAtBigining(Node head,int value)
 {
    Node ptr=new Node(value);
    if(ptr==null)
	{
	  System.out.println("OVERFLOW");
	} 
    else
	{
	  ptr.next=head;
	  if(head!=null)
	    {
		head.prev=ptr;
            }
	  head=ptr;
	System.out.println("NODE HAS BEEN INSERTED");
	}
   return head;
 }

public static Node insertAtEnd(Node head,int value)
 {
    Node ptr=new Node(value);
    if(ptr==null)
	{
	  System.out.println("OVERFLOW");
	} 
    else
	{
	   Node temp=head;
	   while(temp.next!=null)
	    {
 		temp=temp.next;
	    }
	  temp.next=ptr;
	  ptr.prev=temp;
	System.out.println("NODE HAS BEEN INSERTED");
	}
   return head;
 }

public static Node insertAtPosition(Node head,int value,int pos)
 {
    Node ptr=new Node(value);
    if(ptr==null)
	{	
	  System.out.println("OVERFLOW");
	}

    else
	{
	  if(pos==1)
	   {
	      ptr.next=head;
	      if(head!=null)
	        {
	          head.prev=ptr;
		}
	      head=ptr;
	   }

	else
	 {
	    Node temp=head;
	    for(int i=0;i<pos-1 && temp!=null;i++)
		{
		   temp=temp.next;
		}
	    if( temp==null ||(temp.next==null && pos!=2))
		{
		   System.out.println("Position Out of List");
		}
	   else
	    {
              ptr.next = temp.next;
	      ptr.prev=temp;
	      if(temp.next!=null)
		{
	          temp.next.prev=ptr;
		}
	      temp.next=ptr;
	    }
	}

    }
  return head;
 }


public static Node deleteAtBeginning(Node head)
{
   if(head==null)
	{
	   System.out.println("List is Empty");
	}
    else
	{
          head=head.next;
	  if(head!=null)
	   {
             head.prev=null;
	   }
	System.out.println("NODE DELETED AT BIGINING");
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
       
	System.out.println("NODE DELETED AT END");
	}
return head;  
}

public static Node deleteAtPosition(Node head,int pos)
{
   if(head==null)
	{
	  System.out.println("List is Empty");
	}
    else
      {
       if(pos==1)
	 {
	    head=head.next;
	    if(head.next!=null)
	      {
		  head.prev=null;
	      }
	   System.out.println("ELEMENT DELETED AT POSITION: "+pos);
	 }
       else
	 {
	    Node temp=head;
	     for(int i=1;i<pos-1 && temp!=null ;i++)
	     {
		temp=temp.next;
	     }
            if(temp==null || temp.next==null)
	         {
		   System.out.println("OUT OF RANGE OF POSITION");
	         }
	    else
	      {
                Node deleteNode=temp.next; 
	        temp.next=deleteNode.next;
	        if(deleteNode.next!=null)
	         {
	             deleteNode.next.prev=temp;
	         }
	        System.out.println("ELEMENT DELETED AT POSITION: "+pos);
	      }
	}
	
   }
return head;
}

public static void searchElement(Node head,int value)
{
   Node temp=head;
   int pos=1;
   boolean found=false;
   while(temp!=null)
   {
    if(temp.data==value)
	{
	   System.out.println("ELEMENT "+value+" FOUND AT POSITON: "+pos);
	   found=true;
	   break;
	}
     temp=temp.next;
     pos++;
    }

   if(!found)
	{
	  System.out.println("ELEMENT IS NOT FOUND");
	}
}

public static Node updateElement(Node head,int newValue,int pos)
{
   if(head==null)
    {
       System.out.println("Update is Not Possible");
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
	   System.out.println("Position is Not find");
	}
      else
	{
	   temp.data=newValue;
	   System.out.println("VALUE UPDATED");
	}


     }
   return head;
}

public static int traverseLinkedList(Node head)
  {
    int length=0;
    Node current=head;
    while(current!=null)
     {
	System.out.print(current.data+" <-> ");
	current=current.next;
	length++;
     }
	System.out.println();
   return length;
  }

 public static void main(String[] args)
    {

        while (true)
	 {
             System.out.println("1 -> Create Linked List");
             System.out.println("2 -> Insert At Beginning");
             System.out.println("3 -> Insert At End");
             System.out.println("4 -> Insert At any Position");
             System.out.println("5 -> Delete At Beginning");
             System.out.println("6 -> Delete At End");
             System.out.println("7 -> Delete At any Position");
             System.out.println("8 -> Search An Element");
             System.out.println("9 -> Update Element");
             System.out.println("10 -> Display Linked List");
             System.out.println("11 -> Exit");

             System.out.print("Enter a Choice: ");
             int choice = sc.nextInt();

        switch(choice)
            {
                case 1:
                    head=createDoubleyLinkedList();

                       if(head != null)
			 {
                           System.out.println("---Doubly LinkedList Created---");
                           int len1=traverseLinkedList(head);
                           System.out.println("The length of the LinkedList is: "+len1);
                           System.out.println();
                         }
                    break;

                   case 2:
                    System.out.print("Enter the item to insert at beginning: ");
                    int item1=sc.nextInt();
                    head=insertAtBigining(head,item1);
		   int len2=traverseLinkedList(head);
                   System.out.println("The length of the LinkedList is: "+len2);
                   System.out.println();
		   System.out.println("-------------");
                    break;

                 case 3:
                    System.out.print("Enter the item to insert at end: ");
                    int item2 = sc.nextInt();
                    head = insertAtEnd(head,item2);
		    int len3=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len3);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                  case 4:
                    System.out.print("Enter the item to insert: ");
                    int item3 = sc.nextInt();
                    System.out.print("Enter the position to insert: ");
                    int pos1 = sc.nextInt();
                    head = insertAtPosition(head,item3,pos1);
		    int len4=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len4);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                case 5:
                    head = deleteAtBeginning(head);
		    int len5=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len5);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                case 6:
                    head = deleteAtEnd(head);
		    int len6=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len6);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                 case 7:
                    System.out.print("Enter the position to delete: ");
                    int pos2 = sc.nextInt();
                    head = deleteAtPosition(head,pos2);
		    int len7=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len7);
                    System.out.println();
		    System.out.println("-------------");
                    break;

               case 8:
                    System.out.print("Enter the element to search: ");
                    int item4 = sc.nextInt();
                    searchElement(head,item4);
		    int len8=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len8);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                case 9:
                    System.out.print("Enter the new item to update: ");
                    int newItem = sc.nextInt();
                    System.out.print("Enter the position to update: ");
                    int pos3 = sc.nextInt();
                    head = updateElement(head,newItem,pos3);
		    int len9=traverseLinkedList(head);
                    System.out.println("The length of the LinkedList is: "+len9);
                    System.out.println();
		    System.out.println("-------------");
                    break;

                case 10:
                    if(head!=null)
		       {
                          System.out.println("---LinkedList Contents---");
                          int len = traverseLinkedList(head);
                          System.out.println("The length of the LinkedList is: " + len);
                       }
		    else
		       {
                          System.out.println("The LinkedList is empty.");
                       }
                    break;  

                case 11:
                       System.out.println("Exiting...");
                       System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}