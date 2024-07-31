/*5.Assign and print the roll number, phone number and address of two students having names
"Sam" and "John" respectively by creating two objects of class 'Student'.*/

import java.util.*;
public class Details
{
  String name;
  public Details(String name) 
     {
          this.name=name;
     }
   int roll;
   String phone;
   String address;
   public void setDetails(int n,String phone,String address)
       {
         this.roll=n;
         this.phone=phone;
         this.address=address;
       }
   void Display()
      {
         System.out.println(name+" "+roll+" "+phone+" "+address);
      }
    public static void main(String args[])
     {
          Details a=new Details("Sam");
          Details b=new Details("John");
          a.setDetails(1,"6754675678","FoodStreet");
          b.setDetails(2,"8976543567","HappyStreet");
          a.Display();
          b.Display();
     }
}