import  java.util.*;
class Wordsmatch
 {
public int[] findSubstring(String s,String[] words)
   {
     int N =s.length();
     int[] indexes = new int[s.length()];
     int indexCount = 0;
     if (words.length == 0)
      {
            return indexes;
      }
   int M=words[0].length();
   if(N< M * words.length)
     {
            return indexes;
     }
   int last = N - M + 1;
   int[] mappingIndex = new int[words.length];
   int [][] table = new int[2][words.length];
   int failures = 0, index = 0;
   for (int i = 0; i < words.length; ++i)
     {
      int mapped = mappingIndex[i];
      if (mapped == 0) 
      {
          ++failures;
          mappingIndex[i] = index;
          mapped = index++;
       }
       ++table[0][mapped];
     }
   int [] smapping = new int[last];
   for (int i = 0; i < last; ++i)
     {
        String section = s.substring(i, i + M);
         int mapped = -1; 
        for (int j = 0; j < words.length; j++) 
        {
          if(words[j].equals(section))
            {
                    mapped = mappingIndex[j];
                    break;
                }
            }
          smapping[i] = mapped;
        }
   for(int i = 0; i < M; ++i) 
     {
       int currentFailures = failures; 
       int left = i, right = i;
     Arrays.fill(table[1], 0);
     while (right < last) 
       {
         while(currentFailures > 0 && right < last) 
         {
            int target = smapping[right];
           if (target != -1 && ++table[1][target] == table[0][target])
            {
               --currentFailures;
            }
            right += M;
         }
        while(currentFailures == 0 && left < right)
          {
            int target = smapping[left];
            if(target != -1 && --table[1][target] == table[0][target] - 1) 
            {
             int length = right - left;
             if ((length / M) ==  words.length)
              {
                 indexes[indexCount++] = left;
               }
                        ++currentFailures;
                    }
                    left += M;
                }
            }
        }
        return Arrays.copyOf(indexes, indexCount);
    }
public static void main(String args[]) 
 {  
    Wordsmatch ob= new Wordsmatch();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the String: ");
    String s=sc.nextLine();
    System.out.println("Enter the Number of Words: ");
    int n=sc.nextInt();
    String words[]=new String[n];
    System.out.println("Enter the Words: ");
    sc.nextLine();
    for(int i=0;i<n;i++)
     {
       words[i]=sc.nextLine();
     }
   int[] result=ob.findSubstring(s,words);
   System.out.println("Indexes found:");
    System.out.print("[");
     for (int index:result)
        {
            System.out.print(index);
        }
    System.out.print("]");
    } 
}
