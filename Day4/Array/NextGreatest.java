/* 6(L2).Write a Java program to replace every element with the next best element 
(from right side) in a given array of integers.There is no element next to the 
last element, therefore replace it with -1. */


import java.util.Scanner;
public class NextGreatest 
 {
    static void nextGreatest(int arr[],int n)
     {
        for(int i=0;i<n;i++)
	 {
            int maxvalue=-1;
            for(int j=i+1;j<n;j++)
	    {
                maxvalue=Math.max(maxvalue,arr[j]);
            }
            arr[i] = maxvalue;
        }
    }


 public static void main(String[] args) 
  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++)
        {
          arr[i]=sc.nextInt();
        }
        nextGreatest(arr, size);
        System.out.println("The modified array is:");
	for(int i=0;i<size;i++)
	{
            System.out.print(arr[i] + " ");
	}
    }
}
