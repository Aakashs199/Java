/*5.Sorts the ArrayList A in ascending order */


import java.util.*;
public class Arraysort
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
    Collections.sort(list);
    Iterator<Integer> itr=list.iterator();
    while(itr.hasNext())
     {
        System.out.print(itr.next()+" ");
     }
    
 }
}