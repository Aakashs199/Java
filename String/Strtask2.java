
import java.util.*;

public class Strtask2
 {
    static int value(char a) 
  {
        switch(a) {
            case 'I':
                return 1;             
            case 'V':
                return 5;           
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }  
    }

static int convert(String Str) 
  {
    int num = 0;
    for (int i=0;i<Str.length();i++) 
        {
         int prevnum = (i > 0) ? value(Str.charAt(i - 1)) : 0;
         int curnum = value(Str.charAt(i));
         if (prevnum < curnum) 
          {
            num = num - prevnum + (curnum - prevnum);
          } 
       else 
          {
            num += curnum;
          }
    System.out.println(num);
        }
  
        return num;
    }

  public static void main(String args[]) 
{ 
  Scanner sc = new Scanner(System.in);
  String str = sc.nextLine();
  int sum = convert(str);
  System.out.println(sum);
 }
}
