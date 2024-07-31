import java.util.*;
public class Duplicate
 {
  public static void main(String args[])
   {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n=sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements in the array: ");
    for(int i = 0; i < n; i++) 
      {
        arr[i] = sc.nextInt();
      }
   int max1=Integer.MIN_VALUE;
   int max2=Integer.MIN_VALUE;
   int max3=Integer.MIN_VALUE;
   int val1=0,val2=0,val3=0;
   for(int i=0;i<n;i++)
    {
     int count = 0;
     for(int j= i+1;j<n;j++)
      {
        if(arr[i]==arr[j]&&arr[i]!=' ')
        {
         count++;
         arr[j]=' ';
        }
      }
      if(count>max1)
        {
          max3=max2;
          val3=val2;
          max2=max1;
          val2=val1;
          max1=count;
          val1=arr[i];
         } 
       else if(count>max2)
         {
           max3=max2;
           val3=val2;
           max2=count;
           val2=arr[i];
         }
       else if(count>max3)
         {
          max3=count;
          val3=arr[i];
         }
    }

 System.out.print(val1 + " " + val2 + " " + val3);
    }
}



