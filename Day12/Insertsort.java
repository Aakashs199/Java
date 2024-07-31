 import java.util.*;
public class Insertsort
{
public static void insert(int arr[],int n)
   { 
      int i,j,k;
      for(i=1;i<n;i++)
       {
         j=i-1;
         int temp=arr[i];
         while(j>=0&&temp<arr[j])
             { 
                arr[j+1]=arr[j];
                j--;
             } 
         arr[j+1]=temp;  
     }
   }
public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
      System.out.print("Enter the number of element:");

     int n=sc.nextInt();
     int i;
     int arr[]=new int[n];
     System.out.println("Enter the elements in array");
     for(i=0;i<n;i++)
       {
          arr[i]=sc.nextInt();
       }
     insert(arr,n);
    for(i=0;i<n;i++)
     {
        System.out.print(arr[i]+" ");
     }
  } 
}