import java.util.*;
public class Duplicatezero 
{
static void shiftArray(int arr[], int startindex,int n)
  {
    for(int i=n-2;i>=startindex;i--)
     {
       arr[i+1]=arr[i];
     }
  }
  public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n=sc.nextInt();
    int arr[] = new int[n];    
    System.out.print("Enter the values: ");
    for(int i=0;i<n;i++)
        {
         arr[i] = sc.nextInt();
        }
   for (int i=0;i<n-1;i++)
     {
      if(arr[i]==0)
        {
          shiftArray(arr,i+1,n);
          arr[i+1]=0;
          i++;
         }
      }
   System.out.println("Array after duplicating zeros:");
   for(int i=0;i<n;i++)
     {
       System.out.print(arr[i] + " ");
     }
  }
 
}
