/* 3. Given the Binary code of a number as a decimal number, we need to convert this into its
equivalent Gray Code. Assume that the binary number is in the range of integers. For the larger
value, we can take a binary number as string.
In gray code, only one bit is changed in 2 consecutive numbers.
Examples:
Input: 1001
Output: 1101
Explanation: 1001 -> 1101 -> 1101 -> 1101   */


import java.util.*;
class Bin_gray
 {
   int binary_to_gray(int n, int i)
    {
   int a, b;
   int result = 0;
   if(n!=0)
    {
	a = n % 10;
	n = n / 10;
	b = n % 10;
       if((a&~b)==1||(~a&b)==1) 
        {			
         result = (int)(result+pow(10,i));	
	}
	return binary_to_gray(n,++i)+result;
      }
	return 0;
}

   public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Binary Number: ");
       	int binary_number=sc.nextInt();
	int result = 0;
        Bin_gray obj = new Bin_gray();
	result=obj.binary_to_gray(binary_number,0);
	System.out.print(result);
	}
}
