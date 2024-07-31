import java.util.*;
class Strtask7
{
    public static char[] commonChars(String[] A)
 {
     int[][] lowerCase = new int[26][A.length];
     int totalChars = 0;
     for(int i=0; i<A.length;i++) 
      {
        for(int j=0;j<A[i].length();j++)
         {
            lowerCase[A[i].charAt(j)-'a'][i]++;
            totalChars++;
         }
       }
     int[] minOccurrences = new int[26];
      for (int i=0; i<26;i++) 
         {
            int min=lowerCase[i][0];
            for (int j=1; j<A.length;j++) 
           {
                min = Math.min(min,lowerCase[i][j]);
            }
            minOccurrences[i]=min;
        }
     char[] result = new char[totalChars];
     int index = 0;
     for (int i = 0; i < 26; i++) 
      {
       for (int j = 0; j < minOccurrences[i]; j++) 
        {
          result[index++] = (char) (i + 'a');
        }
      }

        return result;
    }
    public static void main(String[] args) 
{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
         String A[]=new String[n];
          sc.nextLine();
          for(int i=0;i<n;i++)
          { 
            A[i]=sc.nextLine();
          }
        char[] result=commonChars(A);
        System.out.println("Common characters:");
        for (char c : result) 
         {
            System.out.print(c + " ");
        }
    }
}
