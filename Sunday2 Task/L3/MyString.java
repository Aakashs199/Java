/* Implement a class called String and has two data member string, length and perform the following
operations?
Note: Write your own implementation. Do not use string handling built-in functions
1. Find the length of the string.
2. Concatenate two string objects.
3. Compares two strings lexicographically.
4. Reverse of the string.
5. Find the index of the specified character.
6. Separate the characters from odd and even-indexed locations and display them.
7. Find the substring by reading the starting index and number of characters from the user.
8. Compares two strings. Returns true if the strings are equal, and false if not
9. Checks whether a string is empty or not
10. Converts this string to a new character array.
11. Converts a string to upper case letters.
12. Removes whitespace from both ends of a string. */

import java.util.*;
public class MyString
 {

   static int getlength(String str)
   {
      int count=0;
     while(true)
      {
         try{
	   if(str.charAt(count)!='\0')
              {
               count++;
	     }
	  }
        catch(StringIndexOutOfBoundsException e)
	   {
              break;
	    }
      }
   return count;
   }

static String concatenate(String str1, String str2) 
 {
   int len1=getlength(str1);
   int len2=getlength(str2);
   char[] result=new char[len1 + len2];

   for(int i=0;i<len1;i++)
    {
       result[i] = str1.charAt(i);
    }
    for(int i=0;i<len2;i++)
     {
       result[len1 + i] = str2.charAt(i);
     }
   return new String(result);
}

static String reverse(String str)
{
   int len=getlength(str)-1;
   int ind=0;
   char arr[]=new char[len+1];
   for(int i=len;i>=0;i--)
    {
      arr[ind]=str.charAt(i);
      ind++;
    }
  return new String(arr);
}

static int compareTo(String str1, String str2)
 {
    int len1=getlength(str1);
    int len2=getlength(str2);
    int minLength=Math.min(len1, len2);
        for(int i=0;i<minLength;i++)
            {
              if(str1.charAt(i) != str2.charAt(i))
	        {
                   return str1.charAt(i)-str2.charAt(i);
                }
        }
        return len1-len2;
    }

static int indexOf(String str,char ch) 
  {
    int len=getlength(str);
       for(int i=0;i<len;i++)
         {
            if(str.charAt(i)==ch)
            {
                return i;
            }
        }
        return -1;
    }
 


static void separateOddEven(String str)
 {
    int len=getlength(str);
   System.out.print("Even Position: ");
    for(int i=0;i<len;i++)
      {
        if(i%2==0)
           {
              System.out.print(str.charAt(i));
           } 
      }
     System.out.println();
  System.out.print("Odd Position: ");
     for(int i=0;i<len;i++)
      {
        if(i%2!=0)
           {
              
              System.out.print(str.charAt(i));
           } 
      }
  System.out.println();
       
    }
    
 static String findSubstring(String str,int startIndex,int numChars)
   {
        int len=getlength(str);
        if(startIndex < 0 || startIndex >= len)
         {
            return "Invalid start index";
         }
        int endIndex = Math.min(startIndex + numChars, len);
        return str.substring(startIndex, endIndex);
    }





static boolean equals(String str1, String str2)
    {
        return compareTo(str1,str2)==0;
    }
    
static boolean isEmpty(String str)
    {
        return getlength(str)==0;
    }


static char[] toCharArray(String str)
 {
     int len=getlength(str);
     char[] charArray=new char[len];
     for(int i=0;i<len;i++)
	 {
           charArray[i]=str.charAt(i);
         }
        return charArray;
    }
    
 static String toUpperCase(String str)
     {
        int len=getlength(str);
        char[] upperCaseArray = new char[len];
        for (int i=0; i<len;i++)
	 {
            char ch=str.charAt(i);
            if (ch >='a'&& ch<='z')
	     {
                upperCaseArray[i]=(char)(ch-'a'+'A');
             } 
	    else
	    {
                upperCaseArray[i] = ch;
            }
        }
        return new String(upperCaseArray);
    }
    
 static String trim(String str)
   {
        int len=getlength(str);
        int start=0;
        int end=len-1;
        while(start<=end && Character.isWhitespace(str.charAt(start)))
	 {
            start++;
         }
        while(end >= start && Character.isWhitespace(str.charAt(end)))
	 {
            end--;
         }
        return str.substring(start, end + 1);
    }





public static void main(String[] args)
  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string1: ");
        String str1=sc.nextLine();
	System.out.println("Enter a string2 :");
        String str2=sc.nextLine();

        System.out.println("Length of String1: "+getlength(str1));
        System.out.println("Length of String 2: "+getlength(str2));
        System.out.println("----------------");

        System.out.println("The Combination of 2 String is: "+concatenate(str1,str2));
        System.out.println("----------------"); 

        System.out.println("Reverse of String1: "+reverse(str1));
        System.out.println("Reverse of String2: "+reverse(str2));
        System.out.println("----------------");

        System.out.println("Lexicographic comparison result: " + compareTo(str1, str2));
        System.out.println("----------------");

       System.out.println("Enter the character to find in String 1:");
       char ch=sc.next().charAt(0);
       System.out.println("Index of "+ch+": "+indexOf(str1, ch));
       System.out.println("Enter the character to find in String 2:");
       char ch1=sc.next().charAt(0);
       System.out.println("Index of "+ch+": "+indexOf(str2, ch1));
       System.out.println("----------------");
  
       System.out.println("Is the string empty? "+ isEmpty(str1));
       System.out.println("----------------");

       System.out.println("Two Strings Are Equals: " + equals(str1,str2));
       System.out.println("----------------");


       System.out.println("Enter a string to separate odd and even-indexed characters:");
       String str6 = sc.next();
      // System.out.println(separateOddEven(str6));
       separateOddEven(str6);
       System.out.println("----------------");

       System.out.println("Enter a string to find substring:");
       String str7 = sc.next();
       System.out.println("Enter the starting index:");
       int startIndex = sc.nextInt();
       System.out.println("Enter the number of characters:");
       int numChars = sc.nextInt();
       System.out.println("Substring: "+findSubstring(str7,startIndex,numChars));
       System.out.println("----------------");
       

       System.out.println("Enter a string to convert to char array:");
       String str3=sc.next();
       char[] charArray=toCharArray(str3);
       System.out.println("String converted to char array: "+new String(charArray));
       System.out.println("----------------");
        
        System.out.println("Enter a string to convert to uppercase:");
        String str4 = sc.next();
        System.out.println("Uppercase string: " +toUpperCase(str4));
        System.out.println("----------------");

        System.out.println("Enter a string to trim:");
        sc.nextLine();
        String str5= sc.nextLine();
        System.out.println("Trimmed string: " +trim(str5));
    }
}
