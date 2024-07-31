import java.util.*;
public class Binaryindex
{
 public static void Binarysearch(int arr[],int n,int find)
  { 
     int i,j,mid,start=0,end=n-1,flag=0;
     mid=(start+end)/2;
     while(start<=end)
      {
         if(arr[mid]==find)
          {
            System.out.println("Element is Found Index: "+mid);
            flag=1;
            break;
           }
          else if(arr[mid]<find)
           {
              start=mid+1;
              
           }
           else
           {
              end=mid-1;
           }
           mid=start+end/2;
        }
      if(flag==0)
       {
         System.out.println("Element to be inserted in Index position: "+n);
        }
     
    }
public static void main(String[] args) 
   {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of elements in array: ");
   int n=sc.nextInt();
   int i,flag=0;
   int arr[]=new int[1000];
   System.out.print("Enter the elements in array: ");
   for(i=0;i<n;i++)
   {
       arr[i]=sc.nextInt();
   }
  System.out.print("Enter the element to be found: ");
  int find=sc.nextInt();
  Binarysearch(arr,n,find);
  }
}
