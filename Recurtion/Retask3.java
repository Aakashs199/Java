import java.util.Scanner;
class Node 
{
  int key;
  Node next;
  public Node(int key)
  {
    this.key = key;
    next = null;
  }
}

public class Retask3
  {
  public static Node newNode(int key)
    {
        return new Node(key);
    }

  public static Node mergeLists(Node a, Node b)
   {
    if (a == null)
       return b;
    if (b == null) 
       return a;
    Node result = new Node(-1);
    Node temp = result;

    while (a != null && b != null)
      {
       if (a.key<b.key)
         {
           temp.next = a;
           a = a.next;
         }
       else 
         {
            temp.next = b;
            b = b.next;
         }
         temp = temp.next;
      }
      if (a != null)
          {
            temp.next = a;
            a=a.next;
            temp=temp.next;
          }
      if(b!=null)
          {
            temp.next = b;
            b=b.next;
            temp=temp.next;
           }
        return result.next;
    }


public static void main(String[] args) 
{
  Scanner sc = new Scanner(System.in);
  System.out.println("Press -1 to stop");
  System.out.println("Enter elements for the first sorted linked list: ");
  Node a = null;
  int key=sc.nextInt();
  if (key!=-1)
    {
      a=new Node(key);
      Node current=a;
      while((key=sc.nextInt())!=-1)
        {
          current.next = new Node(key);
          current = current.next;
        }
     }
   System.out.println("Press -1 to stop");
   System.out.println("Enter elements for the second sorted linked list: ");
   Node b=null;
   key=sc.nextInt();
   if(key!=-1)
    {
      b=new Node(key);
      Node current = b;
      while ((key = sc.nextInt())!=-1)
      {
         current.next = new Node(key);
         current = current.next;
       }
    }
   Node result = mergeLists(a, b);
   System.out.print("Resultant Merge Linked List is : ");
      while (result != null)
        {
          System.out.print(result.key + " ");
          result = result.next;
        }
    }
}
