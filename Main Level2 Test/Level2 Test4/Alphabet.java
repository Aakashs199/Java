import java.util.*;
public class Alphabet
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number of Characters: ");
  int n=sc.nextInt();
  char arr[]=new char[n];

  for(int i=0;i<n;i++)
   {
      arr[i]=sc.next().charAt(0); 
   } 
  System.out.println("Enter the value of N: ");
  int target=sc.nextInt();
  int words[]=new int[26];
  words[arr[0]-97]++;

  for(int i=1;i<n;i++)
    {
      if(arr[i]!=arr[i-1])
	 {
           int ind=arr[i]-97;
	   words[ind]++;
	 } 
    }

  for(int i=0;i<26;i++)
   {
     if(words[i]==target)
	{  
         System.out.print((char)(97+i)+" "); 
        } 
   }

}
}