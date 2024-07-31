import java.util.Scanner;

public class SubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the two strings
        System.out.print("Enter the first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String s2 = sc.nextLine();

        // Find and print the longest common substring
        String result = twoStrings(s1,s2);
        System.out.println("Longest common substring: " + result);
    }
    public static void matrixprint(int arr[][],int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
               System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String twoStrings(String s1, String s2) {
        // We need a two-dimensional array
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        int longest = 0, I = 0, J = 0;

        // Get length for the longest common string
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                {
                    matrix[i][j] = 0;
                } 
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (longest < matrix[i][j]) 
                    {
                        longest = matrix[i][j];
                        I = i;
                        J = j;
			System.out.println("************"+matrix[i][j]+" i: "+I+" j: "+J);
                    }
                }
                else {
                    matrix[i][j] = 0;
                }
            }
        }
        matrixprint(matrix,s1.length()+1,s2.length()+1);

        String resultStr = "";
        while (matrix[I][J] != 0) {
            resultStr = s1.charAt(I - 1) + resultStr; // or s2.charAt(J - 1)
            I--;
            J--;
        }

        // Required longest common substring, could be empty
        return resultStr;
    }
}
