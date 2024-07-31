/* 1.Allocate rank for the university students according to their scores by using Maps, Packages. */

import java.util.*;
public class RankMap
{
@SuppressWarnings("unchecked")public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Number of Marks: ");
int n=sc.nextInt();
int mark[]=new int[n];
Map map=new HashMap();
for(int i=0;i<n;i++)
{
 mark[i]=sc.nextInt();
}
Arrays.sort(mark);
for(int i=n-1;i>=0;i--)
  {
     map.put(n-i,mark[i]);
  }
  Set set=map.entrySet();
  Iterator itr=set.iterator();
  while(itr.hasNext())
   {
    Map.Entry entry=(Map.Entry)itr.next();
    System.out.println(entry.getKey()+" "+entry.getValue());
   }
}
}