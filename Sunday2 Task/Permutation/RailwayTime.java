/* 15. Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of  platforms required for the railway station so that no train waits. We are given two arrays that represent the arrival and departure times of trains that stop. 
Examples:  
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, 
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}  
Output: 3  
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00) 
Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}  
Output: 1  
Explanation: Only one platform is needed.   */
 


import java.util.*; 
class RailwayTime
 { 
  public static void main(String[] args) 
   {  
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the Value of N: ");
      int n=sc.nextInt();
      System.out.println("Enter the Elements: ");
      int[] arrival=new int[n];
      int[] depart=new int[n];
       for(int i=0;i<n;i++)
	  {
   	     arrival[i]=sc.nextInt();
	  }
      for(int i=0;i<n;i++)
       {
   	  depart[i]=sc.nextInt();
	}
    int plat_needed = 1, result = 1; 
    for(int i=0;i<n;i++)
       {  
	  plat_needed = 1; 
	 for(int j=0;j<n;j++)
	   { 
	     if(i!=j)
	       { 
 	       if(arrival[i] >= arrival[j] && depart[j]>=arrival[i])
		 { 
		   plat_needed++;
	         }
	       } 
	    } 
          result = Math.max(result, plat_needed); 
	} 
   
System.out.println(result);		 
   } 
}
