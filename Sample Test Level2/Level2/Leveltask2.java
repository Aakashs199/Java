import java.util.*;
public class Leveltask2
{
 public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int arr[]=new int[n];
     int i,count=1,flag=0,j,max=0;
     for(i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }

     for(i=0;i<n-1;i++)
      {
        count=1;
        for(j=i+1;j<n;j++)
         {        
           if(arr[i]==arr[j])
             {
                 count++;
                 flag=1;
             }
         }
        if(count>max)
         {
           max=count;
         }
      }



   if(flag==0)
    {
      System.out.println("-1");
    }
    else
     {
       System.out.println(n-max);
     }
  
  }
}