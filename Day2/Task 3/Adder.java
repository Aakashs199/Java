/* 3(L2).Can we prevent overloading? if yes code it and explain it */

class Adder
 {
   static int add(int a,int b)
    {
        return a+b;
    }

    static int add(int a,int b,int c)
    {
        return a+b+c;
    }

    static double add(double a, double b)
    {
        return a+b;
    }
   void add(int a,long b)
    {
	System.out.println("------------");
        System.out.println(a+b);
    }
   
 public static void main(String[] args)
   {
     System.out.println("Sum of integers: "+add(30,20));
     System.out.println("Sum of integers: "+add(10,20,30));
     System.out.println("Sum of doubles: "+add(20.3,22.6));

   }
}
