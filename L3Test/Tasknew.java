import java.util.*;
public class Tasknew
 {
   static void display(String lift[], int floor[], int size) 
     {
        System.out.print("Lift Position: ");
        for (int i = 0; i < size; i++) 
           {
            System.out.print(lift[i] + " ");
           }
        System.out.println();
        System.out.print("Floor Positions: ");
        for (int i = 0; i < size; i++)
           {
            System.out.print(floor[i] + " ");
           }
        System.out.println();
     }


  static int nearest(int floor[], int i, int j, int current, int target,int size)
  {
     int a =floor[i];
     int b = floor[j];
     int m = Math.abs(current - a);
     int n = Math.abs(current - b);
     if (n < m)
       {
            return j;
       }
     else if (m == n)
       {
         if (target > a)
            {
              return j;
            } 
         else
            {
                return i;
            }
        } 
     else
         {
            return i;
        }
    }

    static int priority(String lift[], int floor[], int ind1, int current, int target,int left,int right) 
     {
        int val=floor[ind1];
       System.out.println("val: "+val);
        int count=0;
        while(val!=target&&right>=val&&left<=val)
         {
            count++;
            val--;
         }
      System.out.println("count: "+count);
        return count;
    }

   static int assignlift(String lift[], int floor[], int current, int target, int size) 
   {
     int near;
     int val1,val2;
     if (current>5) 
       {
          System.out.println("----------");
          near = nearest(floor, 2, 3, current, target,size);
          System.out.println("Near=: "+near);
          val1 = priority(lift, floor, near,current, target,6,10);
        }
       else
        {
           near = nearest(floor, 0, 1, current, target,size);
           val1 = priority(lift, floor, near,current, target,0,5);
        }
           val2 = priority(lift, floor,4,current, target,0,10);
           int pos=val1<val2?near:4;
           if (val1<val2)
             {
               return near;
             }
           else if (val1==val2)
             {
               if(current<floor[near])
                {
                  return near;
                } 
                else
                {
                return 4;
                }
             } 
       else
           {
            return 4;
           }
    }

  static void assign(String lift[], int floor[], int current, int target, int size) 
   { 
        int ans=assignlift(lift,floor,current,target,size);
        System.out.println("----" + lift[ans] + " is Assigned----");
        floor[ans] = target;
        display(lift, floor, size);
    }

 public static void main(String args[]) 
   {
     Scanner sc = new Scanner(System.in);
     String lift[] = {"L1", "L2", "L3", "L4", "L5"};
     int floor[] = {0,0,0,0,0};
     display(lift,floor,5);
     int size = 5;
     System.out.print("Enter the Current position: ");
     int current = sc.nextInt();
     System.out.print("Enter the Target Position: ");
     int target = sc.nextInt();
     assign(lift, floor, current, target, size);
    }
}
