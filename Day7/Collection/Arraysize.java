/*.7.Sizeof ArrayList */


import java.util.*;
public class Arraysize
{
public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> list=new ArrayList<Integer>();
    list.add(22);
    list.add(44);
    list.add(6);
    list.add(87);
    list.add(180);
    list.add(2);
    list.add(104);
    list.add(1690);
    System.out.print("Size of List: "+list.size());
 }
}