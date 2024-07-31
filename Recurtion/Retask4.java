import java.util.*;
class Node
 {
    int data;
    Node next;
    public Node(int data)
     {
        this.data = data;
        next = null;
    }
}
public class Retask4 
   {
  public static Node newNode(int data)
      {
        return new Node(data);
      }

  public static boolean palindrome(Node a)
    {
      if (a == null || a.next == null)
       {
         return true;
       }
      Node slow = a;
      Node fast = a;
      while (fast != null && fast.next != null)
         {
            slow = slow.next;
            fast = fast.next.next;
         }
        Node firstHalf = a;
        Node secondHalf = reverse(slow);
        while (secondHalf != null)
          {
            if (firstHalf.data != secondHalf.data)
            {
                reverse(secondHalfHead);
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        reverse(secondHalfHead);
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null)
       {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

 public static void main(String args[]) 
   {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the values in nodes: ");
     System.out.println("To exit, press -1");
     Node a = null;
     int value = sc.nextInt();
     if (value != -1)
       {
         a = newNode(value);
         Node current = a;
         while ((value = sc.nextInt()) != -1)
          {
            current.next = newNode(value);
            current = current.next;
          }
        }
   if (palindrome(a))
     {
       System.out.println("TRUE");
     }
  else
    {
       System.out.println("FALSE");
    }
  }
}
