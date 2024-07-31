import java.util.*;
public class Words
{

public static void wordsPrint(int n,String str)
{
   String ones[]={" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thrirteen",
		   "Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
   String tens[]={" "," ","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};

   if(n>19)
     {
          System.out.print(tens[n/10]+" ");
	  System.out.print(ones[n%10]);
     }
   else
     {
	System.out.print(ones[n%100]);
     }
	if(n>0)
	{
	   System.out.print(str+" ");
	}
}



  public static void main(String args[])
    {
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	if(num<0)
	{
	   System.out.println("Negative Number is Not Possible");
	   return;
	}
	else
	{
	   wordsPrint((num/10000000)%100,"Crore");
	   wordsPrint((num/100000)%100,"Lakhs");
	   wordsPrint((num/1000)%100,"Thousand");
	   wordsPrint((num/100)%10,"Hundred");
	   wordsPrint(num%100," ");
	
	}
	
	
    }
}