/*4.Write a Java program to add two binary numbers.*/

import java.util.*;
public class Binaryadd
{
public static void main(String args[])
{ 
  Scanner input=new Scanner(System.in);
  System.out.println("Enter the value of First Binary value: ");
  long First=input.nextLong();

  System.out.println("Enter the value of Second Binary value: ");
  long Second=input.nextLong();

  int i,rem=0,ind=0,flag=0;
  int arr[]=new int[100];
  while(First!=0||Second!=0)
  {
    if((First%10+Second%10)>2)
     {
       System.out.println("Invalid Input");
       flag=1;
       break;
     }
     arr[ind]=(int)((First%10+Second%10+rem)%2);
     ind++;
     rem=(int)((First%10+Second%10+rem)/2);
     First/=10;
     Second/=10;
  }
  if(rem!=0)
  {
     arr[ind]=rem;
  }

  if(flag==0)
  {
    System.out.println("Addition of two Binary values are:  ");
    while(ind>=0)
       { 
          System.out.print(arr[ind--]);
       }
   }
   
}
}