/* 11. Maximum Number of Balls in a Box(Easy)
You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e., n == highLimit -
lowLimit + 1), and an infinite number of boxes numbered from 1 to infinity. Your job at this factory is to put each ball in the box with
a number equal to the sum of digits of the ball's number. For example, the ball number 321 will be put in the box number 3 + 2 + 1 =
6 and the ball number 10 will be put in the box number 1 + 0 = 1.
Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.
Examples:
Input: lowLimit = 1, highLimit = 10
Output: 2
Explanation:
Box Number: 1 2 3 4 5 6 7 8 9 10 11 ...
Ball Count: 2 1 1 1 1 1 1 1 1 0 0 ...
Box 1 has the most number of balls with 2 balls.
Input: lowLimit = 5, highLimit = 15
Output: 2
Explanation:
Box Number: 1 2 3 4 5 6 7 8 9 10 11 ...
Ball Count: 1 1 1 1 2 2 1 1 1 0 0 ...
Boxes 5 and 6 have the most number of balls with 2 balls in each.
Input: lowLimit = 19, highLimit = 28
Output: 2
Explanation:
Box Number: 1 2 3 4 5 6 7 8 9 10 11 12 ...
Ball Count: 0 1 1 1 1 1 1 1 1 2 0 0 ...
Box 10 has the most number of balls with 2 balls.  */


import java.util.*;
public class BoxMax 
{
static int digitsum(int n)
 {
   int rem,sum=0;
   while(n>0)
    {
       rem=n%10;
       sum+=rem;
       n/=10;  
    }

  return sum;
 }    
 public static void main(String[] args)
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the value of LowLimit: ");
     int lowLimit=sc.nextInt();
     System.out.print("Enter the value of HighLimit: ");
     int highLimit =sc.nextInt();
     int box[]=new int[100];
     for(int ball=lowLimit;ball<=highLimit;ball++)
       {
           int sum=digitsum(ball);
           box[sum]++;
       }
   int max=0;
    for(int count: box)
    {
         if(count>max)
      {
        max=count;
      }
    }
        System.out.println("Maximum number of balls in the same box: " +max);
    }
}
