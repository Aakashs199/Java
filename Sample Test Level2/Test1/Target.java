import java.util.*;
public class Target
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the number of Element: ");
  int n=sc.nextInt();
  System.out.print("Enter the Elements: ");
  int i,flag=0;
  int arr[]=new int[n];
  for(i=0;i<n;i++)
   {
     arr[i]=sc.nextInt();
   }
  System.out.print("Enter the target: ");
  int target=sc.nextInt();
  for(i=0;i<n;i++)
   {
      if(arr[i]==target)
      {
        System.out.print("Index: "+i);
        flag=1;
        break;
      }
      if(arr[i]>target)
      {
         System.out.print("Index: "+i);
         flag=1;
         break;
      }
    }
   if(flag==0)
    {
      System.out.println("Index :"+n);
    }
}
}