import java.util.*;
class AngleClock 
{
   static int calcAngle(double h, double m)
     {
	if(h<0 || m< 0 || h>12 || m> 60)
	  {
	     System.out.println("Wrong input");
 	   }

	 if(h==12)
	  {
	    h=0;
	  }

	if(m == 60)
	  {
	    m=0;
	    h+=1;
	    if(h>12)
	     {
		h=h-12;
	     }
	  } 

   	int hourangle = (int)(0.5 * (h*60 + m));
   	int minuteangle = (int)(6 * m);	
	int angle = Math.abs(hourangle - minuteangle);
	angle = Math.min(360-angle,angle);

	return angle;
	}
  public static void main (String[] args) 
    {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the Hour: ");
	int hour=sc.nextInt();
	System.out.print("Enter the Minite: ");
	int min=sc.nextInt();
        System.out.println(calcAngle(hour,min)+" degree");
    }
}

