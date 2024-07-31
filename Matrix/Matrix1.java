import java.util.*;
public class Matrix1
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the number of rows");
  int n=sc.nextInt();
  System.out.println("Enter the number of Coloumn");
  int m=sc.nextInt();
  int i,j;
  sc.nextLine();
  int flag=0;
  String arr[][]=new String[n][m];
   for(i=0;i<n;i++)
   {
    for(j=0;j<m;j++)
     {
    arr[i][j]=sc.next();
      }
   }
  sc.nextLine();
  System.out.println("Enter the String");
  String str=sc.nextLine();
  for(i=0;i<n;i++)
   {   
    StringBuffer str1=new StringBuffer();
    StringBuffer str2=new StringBuffer();
    for(j=0;j<m;j++)
     {
        str1.append(arr[j][i]);
        str2.append(arr[i][j]); 
        if(str.equals(str1.toString())||str.equals(str2.toString()))
        {
          System.out.println(str+" is Present");
          flag=1;
          break;
        }
     }
      if(flag==1)
       {
          break;
       }
   }
    if(flag==0)
      { 
        System.out.println("No String is present");
      }
}
}