import java.util.*;
public class Dynamictask4
{
 public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    n=n+2;
    int arr[]=new int[n];
    int i;
    arr[0]=0;
    arr[1]=0;
    arr[2]=1;
    for(i=3;i<n;i++)
     {
        arr[i]=arr[i-1] + arr[i-2] + arr[i-3];
     }
     System.out.println("The Tribinosis value is: "+arr[n-1]);
  }
}