import java.util.*;
public class Telephone 
  {
  static void printString(String str1, String str2) 
   {
    for(int i = 0; i < str1.length(); i++) 
     {
       for(int j = 0; j < str2.length(); j++) 
	{
           System.out.print(str1.charAt(i) + "" + str2.charAt(j) + " ");
        }
     }
   }

 public static void main(String args[]) 
   {
        Scanner sc = new Scanner(System.in);
        String arr[] = {"", " ", "abc", "def", "ghi", "jkl", "mno", "prqs", "tuv", "wxyz"};
        System.out.print("Enter the Number: ");
        String n = sc.nextLine();
        int num[] = new int[n.length()];
        for(int i=0;i<n.length();i++)
         {
            num[i]=Character.getNumericValue(n.charAt(i)); 
         }
        StringBuilder combine=new StringBuilder("");
        for(int i=0;i<num.length;i++) 
        {
            combine.append(arr[num[i]]);
        }
       System.out.print(combine);
     }
}
