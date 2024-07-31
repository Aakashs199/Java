import java.util.*;
public class Dstask9
{
 public static boolean Rotate(int[] arr, int[][] pieces) 
{
  for (int i=0;i<arr.length;) 
     {
        int k=0;
        while(k<pieces.length && pieces[k][0]!=arr[i])
          {
            ++k;
           }
         if (k==pieces.length)
            {
                return false;
            }
      int j = 0;
         while (j < pieces[k].length && arr[i]==pieces[k][j]) 
             {
                ++i;
                ++j;
              }
        }
        return true;
    }
public static void main(String args[])
{
  int i,j;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the number of elements in array: ");
  int n=sc.nextInt();
  int arr[]=new int[n];
  System.out.println("Enter the Values ");
  for(i=0;i<n;i++)
  {
     arr[i]=sc.nextInt();
   }
  System.out.println("Enter the number of Row in pieces: ");
  int a=sc.nextInt();
  System.out.println("Enter the number of coloumn in pieces: ");
  int b=sc.nextInt();
  int pieces[][]=new int[a][b];
    System.out.println("Enter the Values ");
  for(i=0;i<a;i++)
     for(j=0;j<b;j++)
         pieces[i][j]=sc.nextInt();
  if(Rotate(arr,pieces))
    {
       System.out.println("True");
     }
   else
    {
       System.out.println("False");
    }
     System.out.println(pieces.length);
}
}