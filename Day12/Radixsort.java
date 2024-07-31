import java.util.*;
public class Radixsort
{
public static void count(int arr[],int n,int rem)
   { 
     int output[] = new int[n];
     int i; 
     int count[] = new int[10]; 
     Arrays.fill(count,0); 
       for (i = 0; i < n; i++) 
        {
          count[ (arr[i]/rem)%10 ]++; 
        }

       

       for (i = 1; i < 10; i++) 
         {
            count[i] += count[i - 1]; 
         }
        
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/rem)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/rem)%10 ]--; 
        } 
 for (i = 0; i < 10; i++) 
          {
             System.out.print(count[i]+" ");
          }
         System.out.println();

        for (i = 0; i < n; i++) 
          {
            arr[i] = output[i]; 
          }
        
   }

 public static void radix(int arr[],int n)
  {
    int max = arr[0]; 
    int rem=1; 
    for(int i=1;i<n;i++)
       { 
         if(arr[i]>max)
            { 
                max=arr[i];
            }
        }
    while(max>0)
     {
        count(arr,n,rem);
        rem*=10;
        max/=10;
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
     radix(arr,n);
    for(i=0;i<n;i++)
     {
        System.out.print(arr[i]+" ");
     }
  } 
}