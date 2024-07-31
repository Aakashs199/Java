/*2.Program to show up the vector class and its methods */

import java.util.*;
public class Vectortask
{
@SuppressWarnings("unchecked")public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
 	Vector vec=new Vector();
        vec.add("Akash");
        vec.add(1);
	vec.add(10);
	vec.add('c');
	vec.add(true);
	vec.add(1.1);
	vec.add(6.9999999);
        System.out.println(vec);
	System.out.println(vec.contains("Akash"));
	System.out.println(vec.remove((Integer)10));	
	System.out.println(vec);
	vec.remove(5);
	System.out.println(vec);
	vec.removeElementAt(3);
	System.out.println(vec);
	System.out.println(vec.get(1));
}
}