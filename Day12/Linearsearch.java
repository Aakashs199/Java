
import java.util.*;
public class Linearsearch
{
public static void main(String[] args)
{
   Scanner sc=new Scanner(System.in);
   int arr[]=new int[1000];
    int i,ind=0,flag=0;
    System.out.println("Enter the number of Element in array:");
    int n=sc.nextInt();
    System.out.println("Enter the Elements in array:");
    for(i=0;i<n;i++)
       {
	   arr[i]=sc.nextInt();
	   ind++;
       }
     System.out.println("Enter the Search Element in array: ");
     int find=sc.nextInt();
     for(i=0;i<ind;i++)
	{
	   if(arr[i]==find)
	     {
	        System.out.println("Element is found");
	        flag=1;
	        break;
	     }
        }
   if(flag==0)
	{
	  System.out.println("Element is not found");
	}
}
}
