
import java.util.*;
class SpiralMatrix
  {
   public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
    	System.out.print("Enter the Row: ");
    	int row=sc.nextInt();
	System.out.print("Enter the Col: ");
	int col=sc.nextInt();
	int arr[][]=new int[row][col];
	for(int i=0;i<row;i++)
	 {
	  for(int j=0;j<col;j++)
 	  {
             arr[i][j]=sc.nextInt();
  	  }
	 }
	int[] res = new int[row*col];
	int k=0;
	int left=0;
	int right=col-1;
	int up=0;
	int bottom=row-1;

	while(k<row*col)
	 {
	     for(int i=left;i<right;i++) 
		{         
		    res[k++]=arr[left][i];  
		}

	      for(int i=up;i<bottom;i++)
		{ 
		    res[k++]=arr[i][right];		  
		}

	        for(int i=right;i>left;i--) 
		{
		     res[k++] = arr[bottom][i];	   
 		}

		for(int i=bottom;i>up;i--) 
		 {
			res[k++] = arr[i][left];		     
		 }
		left++;
		right--;
		up++;
		bottom--;
		}



		for(int i=0;i<k;i++) 
                  {
                     System.out.print(res[i]+" ");    
                  }
	}
}