import java.util.*;
public class Dynamictask2
{
  static int cost(int i,int n,int arr[],int dummy[])
  {
     if(i>=n)
      {
        return 0;
      }  
     if(dummy[i]!=-1)
      {
          return dummy[i];
      }
     dummy[i]=arr[i]+Math.min(cost(i+2,n,arr,dummy),cost(i+1,n,arr,dummy));
     return (int)dummy[i];
   
  }
  public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int arr[]=new int[n];
      int i;
      for(i=0;i<n;i++) 
       {
         arr[i]=sc.nextInt();
       }
       int dummy[]=new int[n+11];
       Arrays.fill(dummy,-1);
       int ind1=cost(0,n,arr,dummy);
       int ind2=cost(1,n,arr,dummy);
       System.out.println(Math.min(ind1,ind2));
    }
}