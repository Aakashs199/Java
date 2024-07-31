import java.util.*;
public class Practice
{
static StringBuilder str=new StringBuilder();
static void generate(int arr[],int ind)
  {
     if(ind==arr.length)
      {
         for(int i=0;i<str.length();i++)
         {
            System.out.print(str.charAt(i));
         }
       System.out.println();
       return;
      }
    str.append(arr[ind]);
    generate(arr,ind+1);
    str.deleteCharAt(str.length()-1);
    while(ind+1<arr.length && arr[ind]==arr[ind+1])
     {
       ind++;
     }
    generate(arr,ind+1);
   
  }
 public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int arr[]=new int[n];
   for(int i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
    generate(arr,0);
   }
}