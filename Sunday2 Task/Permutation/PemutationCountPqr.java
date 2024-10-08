import java.io.*;
import java.util.*;
class PemutationCountPqr
{
 static int countWays(int p, int q, int r, int last)
  {
    if(p<0||q<0||r<0)
        {
          return 0;
        }

  if(p==1 && q==0 && r==0 && last==0)
      {
            return 1;
        }    
   if(p==0 && q==1 && r==0 && last==1)
     {
            return 1;
        }
        
   if(p == 0 && q == 0 && r == 1 && last == 2)
     {
            return 1;
        }
        
     if(last == 0)
      {
          return countWays(p-1,q,r,1)+countWays(p-1,q,r,2);
       }

    if(last == 1)
      {
            return countWays(p,q-1,r,0)+countWays(p,q-1,r,2);
        }

    if(last == 2)
       {
            return countWays(p,q,r-1,0)+countWays(p,q,r-1,1);
        }
        return 0;
    }

static int countUtil(int p, int q, int r)
    {
        return countWays(p, q, r, 0)+countWays(p, q, r, 1)+countWays(p, q, r,2); 
    }

 public static void main(String[] args)
 {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the value of P: ");
    int p=sc.nextInt();
    System.out.print("Enter the value of Q: ");
    int q=sc.nextInt();
    System.out.print("Enter the value of R: ");
    int r=sc.nextInt();
    int ans = countWays(p, q, r, 0)+countWays(p, q, r, 1)+countWays(p, q, r,2); 
    System.out.print(ans);
    }
}

