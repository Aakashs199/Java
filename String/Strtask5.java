import java.util.*;
public class Strtask5
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  int i,j,min=Integer.MAX_VALUE,ans=-1;
  int n=sc.nextInt();
  String arr1[]=new String[n];
  sc.nextLine();
   for(i=0;i<n;i++)
   {
     arr1[i]=sc.nextLine();
   }
  int m=sc.nextInt();
  String arr2[]=new String[m];
   sc.nextLine();
   for(i=0;i<m;i++)
   {
     arr2[i]=sc.nextLine();
   }
   for(i=0;i<n;i++)
    {
       String current=arr1[i];
         for(j=0;j<m;j++)
         {
           if(current.equals(arr2[j]))
            {
              int ind=i+j;
              if(ind<min)
                  {
                    min=ind;
                    ans=i;
                  }
            }
         }

    }
  System.out.println("Both Liked Hotel are: "+arr1[ans]);
}
}