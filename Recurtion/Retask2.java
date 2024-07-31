import java.util.Scanner;
public class Retask2 
{
 public static void swap(char arr[],int start,int end)
  {
    if (start>=end)
     {
       return;
     }
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        swap(arr, start + 1, end - 1);
   }
    public static void main(String args[]) 
  {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of characters: ");
        int n = sc.nextInt();
        char arr[] =new char[n];
        sc.nextLine();
        System.out.println("Enter the characters: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.next().charAt(0);
        }
        swap(arr, 0, n - 1);
        System.out.println("Reversed array:");
        for (char ans : arr) 
        {
            System.out.print(ans + " ");
        }
    }
}


