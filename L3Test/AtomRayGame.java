import java.util.*;
public class AtomRayGame
 {

  static boolean check(int i,int j,int n,String arr[][])
  {
    if(i>=0&&j>=0&&i<n&&j<n&&arr[i][j].equals("x"))
     {
       return true;
     }
    return false;
  }

 static int valueOf(String str)
  {
    if(str.equals("R3") || str.equals("C1")) 
      {
        return 0;
      } 
    else if(str.equals("R2")||str.equals("C2"))
      {
        return 1;
      }
   else if(str.equals("R1")||str.equals("C3")) 
      {
        return 2;
      }
    return -1;
  }

  static boolean isPresentRow(String target, String row[]) 
   {
     for(int i=0; i<row.length;i++) 
      {
        if(row[i].equals(target))
         {
           return true;
         }
      }
    return false;
   }

  static boolean isPresentColumn(String target, String col[]) 
   {
     for(int i = 0;i<col.length;i++) 
      {
        if(col[i].equals(target)) 
          {
            return true;
          }
       }
      return false;
    }
 
 public static void main(String args[]) 
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns: ");
    int numRows = sc.nextInt();
    int numCols = sc.nextInt();
    sc.nextLine();
    String arr[][] = new String[numRows][numCols];
    for(int i=0;i<numRows;i++)
       {
         System.out.print("Enter atoms for row " + (i+1) + ": ");
         String atomsRow = sc.nextLine();
         String[] atoms = atomsRow.split(" ");
         for(int j = 0; j < numCols; j++)
           {
              arr[i][j]=atoms[j];
           }
        }    
     String row[] = {"R3", "R2", "R1"};
     String col[] = {"C1", "C2", "C3"};
     String row1[] = {"", "", ""};
     String col1[] = {"", "", ""};
     String row2[] = {"", "", ""};
     String col2[] = {"", "", ""};
     System.out.print("Enter the number of Rays: ");
    int numRays = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter the Rays: ");
     String inputRays[]=new String[numRays];
       for(int i = 0; i < numRays; i++)
        {
          inputRays[i]=sc.nextLine();
        }


    for(int i = 0; i < numRays; i++)
      {
        int value = valueOf(inputRays[i]);
        if(inputRays[i].charAt(0) =='R'&& isPresentRow(inputRays[i], row))
         { 
           
           for(int j=0;j<numCols;j++)
             {
               if(arr[value][j].equals("x"))
                 {
                   
                   row1[value] += "H";
                   break;
                 }
             }
            System.out.println(value-1+" "+value);
                          
        System.out.println("******");
           for(int j=0;j<numRows;j++)
            {
              if(check(value-1,value,numRows,arr)||check(value+1,value,numRows,arr))
              {
                col2[value-1] = inputRays[i];
                row1[value] = inputRays[i];
                break;
              }
            } 
         }              
         
    
     else if(inputRays[i].charAt(0) =='C'&& isPresentRow(inputRays[i], col))
         {  
          int value = valueOf(inputRays[i]);
           for(int j=numCols-1;j>=0;j--)
             {
               if(arr[j][value].equals("x"))
                 {
                   col2[value] += "H";
                   break;
                 }
             }
            System.out.println(value-1+" "+value);
                          
        System.out.println("******");
           for(int j=0;j<numRows;j++)
            {
              if(check(value-1,value-1,numRows,arr)||check(value+1,value,numRows,arr))
              {
                col2[value-1] = inputRays[i];
                row1[value] = inputRays[i];
                break;
              }
            } 
         }              
         
        }



    for(int k=0;k<3;k++)
     {
       System.out.print(col1[k]+",");
     }
     System.out.println();
   for(int i = 0; i < numRows; i++)
     {
       System.out.print(row1[i]+"|");
       for(int j = 0; j < numCols; j++)
        {
          System.out.print(arr[i][j] + " ");
        }
       System.out.print(row2[i]+"|");
         System.out.println();
     }
     for(int l=0;l<3;l++)
     {
      System.out.print(col2[l]+",");
     }

System.out.println();

    for(int j=0;j<3;j++)
     {
      System.out.print(row[j]+" ");
     }
    System.out.println();
    for(int j=0;j<3;j++)
     {
      System.out.print(col[j]+" ");
     }
    
    }
}
