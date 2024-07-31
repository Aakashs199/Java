import java.util.*;
public class Pattern
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the String: ");
  String str=sc.nextLine();
  System.out.println("Enter the rows:");
  int n=sc.nextInt();
  String arr[]=new String[n];
  boolean check=false;
  int row=0,i;
  for(i=0;i<n;i++)
   {
     arr[i]="";
   }

  for(i=0;i<str.length();i++)
   {
    if(row>=0)
      {
        arr[row]+=(str.charAt(i));
      }
    if(row==n-1)
     {
       check=false;
     }
     if(row==0)
      {
        check=true;
      }
    if(!check)
     {
       row--;
     }
    else
     {
        row++;
      }
   }

   for(i=0;i<n;i++)
   {
     System.out.print(arr[i]);
   }
}
}