import java.util.*;
public class Mergesorting
{
public static void mergesort(int arr[],int start,int mid,int last)
   { 
       int i,j,k;
       System.out.println("start= "+start+" mid= "+mid+" last= "+last);
       int ind1=mid-start+1;
       int ind2=last-mid;
       System.out.println("ind1= "+ind1+" ind2= "+ind2);
      
       int left[]=new int[ind1];
       int right[]=new int[ind2];
       for(i=0;i<ind1;i++)
         {
            left[i]=arr[start+i];
         }                                  
        for(j=0;j<ind2;j++)
         {
            right[j]=arr[mid+1+j];
         }
      i=0;
      j=0;
      k=start;

      while(i<ind1&&j<ind2)
     {
         if(left[i]<=right[j])
         {
             arr[k]=left[i];
             i++;
         }
         else
          {
             arr[k]=right[j];
             j++;
           }
        k++;
     }
         while(i<ind1)
         {
            arr[k]=left[i];
            i++;
            k++;
         }
         while(j<ind2)
         {
            arr[k]=right[j];
            j++;
            k++;
         }
               
   }

public static void merge(int arr[],int start,int last)
{   
    if(start<last)
    { 
       int mid=(start+last)/2;
       merge(arr,start,mid);  
       merge(arr,mid+1,last);
       mergesort(arr,start,mid,last);
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
     merge(arr,0,n-1);
     System.out.print("Sorted Array is: ");
     for(i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
  } 
}