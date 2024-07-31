import java.util.*;
public class Selectionsort
{
public static void select(int arr[],int n)
   { 
        int i,j,temp;
        for (i=0;i<n-1;i++)     
          {  
            int min= i;  
           for (j=i+1;j<n;j++)  
             {
                if (arr[j]<arr[min])
                  {  
                     min=j;
                  }  
       temp=arr[min];  
       arr[min]=arr[i];  
       arr[i]=temp;  
             }  
           }
   }
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the number of element:");
     int n=sc.nextInt();
     int i;
     int arr[]=new int[1000];
     System.out.println("Enter the elements in array");
     for(i=0;i<n;i++)
       {
          arr[i]=sc.nextInt();
       }
     select(arr,n);
     System.out.println("Sorted Array is: ");
     for(i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
  } 
}