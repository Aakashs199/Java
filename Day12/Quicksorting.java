import java.util.*;
public class Quicksorting
{
public static int partition(int arr[],int start,int last)
   { 
     int i,j,temp;
    System.out.println(start+" "+last);
     int pivot=arr[last];
     i=(start-1);
     for(j=start;j<=last-1;j++)
        {
           if(arr[j]<pivot)
             {
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
              }
        } 
      temp=arr[i+1];
      arr[i+1]=arr[last];
      arr[last]=temp;
      
      return(i+1); 
                     
   }

public static void quick(int arr[],int start,int last)
{
    if(start<last)
    {
       int p=partition(arr,start,last);
       System.out.println(p);
       quick(arr,start,p-1);
       quick(arr,p+1,last);
      
    }

}

public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the number of element: ");
     int n=sc.nextInt();
     int i;
     int arr[]=new int[1000];
     System.out.print("Enter the elements in array: ");
     for(i=0;i<n;i++)
       {
          arr[i]=sc.nextInt();
       }
     quick(arr,0,n-1);
     System.out.print("Sorted Array is: ");
     for(i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
  } 
}