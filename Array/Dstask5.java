import java.util.*;
public class Dstask5
 {
    public static String action(String str, int k)
 {
    int len = str.length() / k;
    int ind = len * k;
    StringBuilder ans1=new StringBuilder();
    StringBuilder ans2=new StringBuilder();
    int i,j;
   for(i=0;i<ind;i+=k)
     {
        int sum = 0;
       for(j=i;j<i+k;j++)
            {
                sum+=(str.charAt(j)-'0');
            }
            ans1.append(sum);
        }
     int sum = 0;
     for(i=ind;i<str.length();i++)
        {
          sum += (str.charAt(i) - '0');
        }
        ans2.append(sum);
        String ans3=ans1+""+ans2;
        if(ans3.length()%k!=0)
          {
             return action(ans3,k);
          }
         else
          {
              return ans3;
           }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine(); // Consume newline after reading integer
        String str = sc.nextLine();
        System.out.println(action(str,k));
    }
}
