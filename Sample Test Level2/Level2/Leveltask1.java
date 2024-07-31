import java.util.*;
public class Leveltask1
{
 public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int arr[]=new int[n];
     int i,min=n,flag=0,ind,j;
     for(i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }

     for(i=0;i<n;i++)
      {
        for(j=i+1;j<n;j++)
         {
           ind=j-i;
           if(arr[i]==arr[j]&&ind<min)
             {
                 min=ind;
                 flag=1;
              }
         }
      }

   if(flag==0)
    {
      System.out.println("-1");
    }
    else
     {
       System.out.println(min);
     }
  
  }
}