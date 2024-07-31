/* 1. Problem Statement – An automobile company manufactures both a two wheeler (TW) and a four wheeler (FW). A company manager wants to make the production of both types of vehicle according to the given data below:

1st data, Total number of vehicle (two-wheeler + four-wheeler)=v
2nd data, Total number of wheels = W
The task is to find how many two-wheelers as well as four-wheelers need to manufacture as per the given data.
Example :

Input :
200  -> Value of V
540   -> Value of W

Output :
TW =130 FW=70

Explanation:
130+70 = 200 vehicles
(70*4)+(130*2)= 540 wheels

Constraints :

2<=W
W%2=0
V<W
Print INVALID INPUT , if inputs did not meet the constraints.

Written program code should generate two outputs, each separated by a single space character(see the example)
Additional messages in the output will result in the failure of test case.  */

import java.util.*;
public class Wheller
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Number of Vehicles: ");
int V=sc.nextInt();
System.out.print("Enter the Number of Wheels: ");
int W=sc.nextInt();
        
 if(W<=2 || W%2!=0 || V>W)
   {
	System.out.println("Invalid Input");
	return;
   }
  int FW=(W-2*V)/2;
  int TW=V-FW;
        
  System.out.println("TW ="+TW+" FW="+FW);


}
}
