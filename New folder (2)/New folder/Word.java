import java.util.*;
public class Word
{
  public static void pw(int n,String str)
   {
         String[] one={" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","seventeen","Eighteen","Ninteen"};
         String[] ten={" "," ","Twenty","Thirteen","Fourteen","Fifty","Sixty","Seventy","Eighty","Ninty"};
         if(n>19)
        {
            System.out.print(ten[n/10]+" ");
            System.out.print(one[n%10]);
        }
         else
         {
           System.out.print(one[n%10]); 
         }
        if(n>0)
         {
          System.out.print(str+" "); 
         }
   }
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the digit: ");
      int n=sc.nextInt();
      if(n<0)
         {
             System.out.println("Please Enter the positive value");
         }
       else
        {
           pw(n/1000000000,"Hundred");

           pw((n/10000000)%100,"Crore");

           pw((n/100000)%100,"Lakhs");

           pw((n/1000)%100,"Thousand");

           pw((n/100)%10,"Hundred");

           pw(n%100,"");
        }

  }
}
