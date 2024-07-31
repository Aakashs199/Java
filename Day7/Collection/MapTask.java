/* 10.Implement Map using Java  */

import java.util.*;
public class MapTask
{
@SuppressWarnings("unchecked")public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	Map map=new HashMap();
	map.put(1,"Akash");
	map.put(2,"Abhishek");
	map.put(3,"Balaji");
	map.put(4,"Hari");
  	Set set=map.entrySet();
	Iterator itr=set.iterator();
	while(itr.hasNext())
	{
	  Map.Entry entry=(Map.Entry)itr.next();
	  System.out.println(entry.getKey()+" "+entry.getValue());
	}
}
}