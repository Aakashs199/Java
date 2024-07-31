import java.util.*;
public class Parentheses
{
static int maxiNum(String str)
{
 int len=str.length();
 Stack<Integer> stack=new Stack<Integer>();
 for(int i=0;i<len;i++)
  {
    if(str.charAt(i)=='(')
     {
        stack.push(i);
     }
     else
      {
        if(!stack.isEmpty() && str.charAt(stack.peek()) == '(')
	{
	  stack.pop();
	}
	else
	{
	  stack.push(i);
	}
      }
  }
int result=0;
int last=len;
while(!stack.isEmpty())
  {
     int current=stack.pop();
     result=Math.max(result,last-current-1);
     last=current;
  }
return Math.max(result,last);
}

public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the Parenthesis: "); 
  String str=sc.nextLine();
  System.out.print(maxiNum(str));
}
}