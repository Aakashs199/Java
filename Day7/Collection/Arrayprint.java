/* 8. Prints space separated values of the ArrayList */


import java.util.*;
public class Arrayprint
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
    for(int i=0;i<list.size();i++)
	{
         System.out.print(list.get(i)+" ");
        }
 }
}