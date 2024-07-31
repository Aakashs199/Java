class Testpracticejump 
{
    public static void main(String[] args) 
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number of Elements in Array: ");
  int size=sc.nextInt();
  int arr[]=new int[size];
  System.out.print("Enter the Elements: ");
  for(int i=0;i<size;i++)
  {
    arr[i]=sc.nextInt();
  }
 if(size<=1) 
   {
     System.out.println(0);
     return;
    }
if(arr[0]>=size-1) 
   {
      System.out.println(1);
      return;
   }
 if(arr[0]==0)
   {
      System.out.println(-1);
      return;
   }

   int maxReach = arr[0];
   int step = arr[0];
   int jump = 1;
  for(int i=1;i<arr.length;i++)
      {
         if(i==arr.length-1) 
	  {
            System.out.println(jump);
            return;
          }
         if(arr[i]>=(arr.length-1)-i)
	   {
                System.out.println(jump + 1);
                return;
           }

            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if(step == 0)
	     {
                jump++;
                if(i >= maxReach) 
	        {
                    System.out.println(-1);
                    return;
                }
                step = maxReach - i;
            }
        }

        System.out.println(-1);
    }
}
