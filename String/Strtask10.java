import java.util.*;
class Strtask10 
{
  public static void main(String[] args) 
{
   Scanner sc = new Scanner(System.in);
   System.out.print("Enter a string: ");
   String str = sc.nextLine();
   int len = str.length();
   if (len % 2 == 0) 
   {
     System.out.println("Not Possible");
     return;
   }
   int mid = len / 2;

   for (int i = 0; i <= mid; i++)
     {
       for (int j = 0; j < mid - i; j++) 
         {
           System.out.print(" ");
         }
        if (i==0)
         {
           System.out.print(str.charAt(mid));
         }

    else
     {
        int ind=(i+i)-1;
        System.out.print(str.charAt(mid - i));
        for (int j=1; j <=ind;j++) 
          {
             System.out.print(" ");
          }
       System.out.print(str.charAt(mid + i));
      }
            System.out.println();
        }   

   for (int i=mid-1;i>=0;i--)
    {
       for (int j=0; j<mid-i;j++)
           {
              System.out.print(" ");
            }
            if (i==0) 
            {
                System.out.print(str.charAt(mid));
            } 
           else
             {
                int ind=i+i-1;
                System.out.print(str.charAt(mid - i));
                for (int j=1;j<=ind;j++) 
                {
                    System.out.print(" ");
                }
                System.out.print(str.charAt(mid + i));
            }

            System.out.println();
        }
    }
}
