import java.util.*;
public class Pair
{
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the number of Elements: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i,j,count=0;
   System.out.print("Enter the value: ");
   for(i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
   boolean visited[]=new boolean[n];
   for(i=0;i<n-1;i++)
     {
       if(!visited[i])
         {
          for(j=i+1;j<n;j++)
            {
              if(arr[i]==arr[j])
               {
                 visited[j]=true;
                 count++;
                 break;
                }  
             }
           }
       }
     if(count==n/2&&n%2==0)
       {
         System.out.print("TRUE");
       }
    else
     {
        System.out.print("FALSE");
     }
 }
}