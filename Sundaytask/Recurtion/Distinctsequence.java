/* 6. Given a set S, generate all distinct subsets of it, i.e., find distinct power set of set S. A power set
of any set S is the set of all subsets of S, including the empty set and S itself.
For example, if S is set {x, y, x}, then the subsets of S are:
{} (also known as the empty set or the null set).
{x}
{y}
{x}
{x, y}
{x, x}
{y, x}
{x, y, x}
Therefore, distinct subsets in the power set of S are: { {}, {x}, {y}, {x, y}, {x, x}, {x, y, x} }.  */



import java.util.*;
class Distinctsequence
{
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args){
   Scanner in = new Scanner(System.in);
   int n = in.nextInt();
   char arr[] = new char[n];
   for(int i=0;i<n;i++)
     {
     arr[i]=in.next().charAt(0);
     }
   subset(arr,0);
}

public static void subset(char[] arr, int idx)
  {		
      if(idx==arr.length)
        {
	  System.out.print("[");
	  for(int i=0;i<sb.length();i++)
	    {
	      System.out.print(sb.charAt(i)+",");
	    }
	 System.out.print("]");
	 System.out.println();
	 return;
	}
  sb.append(arr[idx]);
  subset(arr,idx+1);
  sb.deleteCharAt(sb.length()-1);
  while(idx+1<arr.length && arr[idx]==arr[idx+1])
   {
    idx++;
   }
  subset(arr,idx+1);
		
	}
}