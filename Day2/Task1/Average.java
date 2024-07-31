/*4.Print the average of three numbers entered by user by creating a class named 'Average' having a method to calculate and print the average.*/

import java.util.*;
public class Average
{   
  float n1,n2,n3;  
  public Average(float n1,float n2,float n3)
   {
      this.n1=n1;
      this.n2=n2;
      this.n3=n3;
   }
  float average()
     {
        float average=(n1+n2+n3)/3;
        return average;
      }
    public static void main(String args[])
     {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first value");
        float n1=sc.nextFloat();
          System.out.println("Enter the second value"); 
        float n2=sc.nextFloat();
         System.out.println("Enter the third value");
        float n3=sc.nextFloat();
        Average ob=new Average(n1,n2,n3);
        System.out.println("The average is: "+ob.average());
     }
   
}