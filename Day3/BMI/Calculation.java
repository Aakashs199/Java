/* (L3).Create a BMI calculator by using packages and it should follows,

Create a package file 1 that contains a class that accepts a basic data members need for your calculator.
Create a crisp method to calculate a BMI and return the result
Create another package file and create an object for the file 1 class and pass the respective arguments then call the method */

package calculator;
public class Calculation
{
  double height,weight;
  public Calculation( double height,double weight)
   {
      this.height=height;
      this.weight=weight;
   }
 
   public double calculateBmi()
	{
	   double ans=(height*height)/10000;
	   return(weight/ans); 
	}
}
