import java.util.*;
class TrainBerth
{
public static void main(String[] args)
 {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter seat number: ");
    int s = scanner.nextInt();
    if(s>0&&s<73)
     {
       if(s%8==1||s%8==4)
 	{
          System.out.println(s+" is lower berth");
	}	
        else if(s%8==2||s%8==5)
	{
          System.out.println(s+" is middle berth");
        }
        else if(s%8==3||s%8==6)
	{
         System.out.println(s+" is upper berth");
	}
       else if(s%8==7)
	{
          System.out.println(s+ " is side lower berth");
 	}
         else
	 {
          System.out.println(s+ " is side upper berth");
       	 }
      }
     else
       {
         System.out.println(s+ " invalid seat number");
       }

    }
}
