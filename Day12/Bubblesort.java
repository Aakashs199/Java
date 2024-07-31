import java.util.*;
public class Bubblesort
{
public static void Bubble(int arr[],int n)
   { 
       int i,j,temp,k;
       for(i=0;i<n-1;i++)
       {
         for(j=i+1;j<n;j++)
          {
             if(arr[j]<arr[i])
               {
                   temp=arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
               }
          }
         
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
     Bubble(arr,n);
     System.out.println("Sorted Array is: ");
     for(i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
  } 
}