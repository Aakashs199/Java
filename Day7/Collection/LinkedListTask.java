/* 4.Make a searching, inserting,deleting and updating operation in Linked list*/


import java.util.*;
public class LinkedListTask
{
public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    LinkedList<Integer> list=new LinkedList<Integer>();
    list.add(2);
    list.add(4);
    list.add(6);
    list.add(8);
    list.add(10);
    list.add(12);
    list.add(14);
    list.add(16);
    System.out.println(list);
    list.remove(0);
    System.out.println(list);
    Integer i=new Integer(16);
    list.remove(i);
    System.out.println(list);
    System.out.println(list.contains(4));
    list.add(2,0);
    list.addAll(list);
    System.out.println(list);
 }
}