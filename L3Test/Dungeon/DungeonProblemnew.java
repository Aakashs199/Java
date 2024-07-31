import java.util.*;
public class DungeonProblemnew
{

public static int arr1[]={0,1,-1,0};
public static int arr2[]={1,0,0,-1};

 public static int minStepToGold(int row,int col,int startX,int startY,int goldX,int goldY,char[][] arr,List<int[]> path,int position) 
    {
        boolean[][] visited = new boolean[row][col];
        int[] minSteps={Integer.MAX_VALUE};
        List<int[]> currentPath = new ArrayList<>();
        dfs(startX,startY,goldX,goldY,0,visited,row,col,minSteps,arr,currentPath,path,position);
        return minSteps[0];
     }

  private static void dfs(int x, int y, int goldX, int goldY, int steps, boolean[][] visited, int row, int col, int[] minSteps, char[][] arr, List<int[]> currentPath, List<int[]> path,int position) 
       {
         if(position==1)
	  {
            if(x<0 || x>=row || y<0 || y>=col || visited[x][y] || arr[x][y]=='P')
	     {
              return;
             }
	  }
	else
	{
        if(x<0 || x>=row || y<0 || y>=col || visited[x][y])
	     {
              return;
             }
	}

        currentPath.add(new int[]{x+1, y+1});

        if(x==goldX && y==goldY)
	 {
            if(steps<minSteps[0]) 
	     {
                minSteps[0] = steps;
                path.clear();
                path.addAll(new ArrayList<>(currentPath));
             }

            currentPath.remove(currentPath.size() - 1);
            return;
        }

     visited[x][y]=true;
     for(int i=0;i<4;i++)
	 {
            int newX = x+arr1[i];
            int newY = y+arr2[i];
            dfs(newX,newY,goldX,goldY,steps+1,visited,row,col,minSteps,arr,currentPath,path,position);
         }

     visited[x][y] = false;
     currentPath.remove(currentPath.size() - 1);

    }


public static void display(char arr[][],int row,int col)
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

public static void fillArray(char arr[][],int row,int col)
{
  for(int i=0;i<row;i++)
   {
      for(int j=0;j<col;j++)
	{
	   arr[i][j]='-';
	}
   }
}




 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   boolean check=true;
   while(check)
	{
	   System.out.println("Enter the Choice");
	   System.out.println("1.Only Adventure");
	   System.out.println("2.Both Adventure and Monster");
	   System.out.println("3.Print Path");
	   System.out.println("4.Add Triggers");
	   System.out.println("5.Only Pit and Adventure");
	   System.out.println("6.Pit with Adventure and Monster");
	   System.out.println("7.Pit with Adventure,Monster and Trigger");
	   System.out.println("8.Exit");
	   System.out.println();
	   int choice=sc.nextInt();
	   
	 switch(choice)
	  {
		case 1:
                        System.out.print("Enter the Number of Rows: ");
			int row=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col=sc.nextInt();
			char arr[][]=new char[row][col];
			fillArray(arr,row,col);
			System.out.print("Enter the Position of Adventure: ");
			int advRow=sc.nextInt();
			int advCol=sc.nextInt();
			arr[advRow-1][advCol-1]='A';
			System.out.print("Enter the Position of Gold: ");
			int goldRow=sc.nextInt();
			int goldCol=sc.nextInt();
			arr[goldRow-1][goldCol-1]='G';
			display(arr,row,col);
			List<int[]> adventurePath = new ArrayList<>();
			int step1=minStepToGold(row,col,advRow-1,advCol-1,goldRow-1,goldCol-1,arr,adventurePath,1);  
			System.out.println("MinimumNumber of Steps Required for Adventure: "+step1);
			System.out.println("---------------------------------");
			break;
		case 2:
			System.out.print("Enter the Number of Rows: ");
			int row2=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col2=sc.nextInt();
			char arr2[][]=new char[row2][col2];
			fillArray(arr2,row2,col2);
			System.out.print("Enter the Position of Adventure: ");
			int advRow2=sc.nextInt();
			int advCol2=sc.nextInt();
			arr2[advRow2-1][advCol2-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow2=sc.nextInt();
			int goldCol2=sc.nextInt();
			arr2[goldRow2-1][goldCol2-1]='G';
			

			System.out.print("Enter the Position of Monster: ");
			int monRow2=sc.nextInt();
			int monCol2=sc.nextInt();
			arr2[monRow2-1][monCol2-1]='M';

			display(arr2,row2,col2);
			List<int[]> adventurePath2 = new ArrayList<>();
			List<int[]> monsterPath2 = new ArrayList<>();
			
			int step2=minStepToGold(row2,col2,advRow2-1,advCol2-1,goldRow2-1,goldCol2-1,arr2,adventurePath2,1); 
			int step3=minStepToGold(row2,col2,monRow2-1,monCol2-1,goldRow2-1,goldCol2-1,arr2,monsterPath2,0)+1;

		        System.out.println("Steps For Adventure: "+step2);
			System.out.println("Steps for Monster: "+step3);
         		if(step2<step3)
			{
			   System.out.println("MinimumNumber of Steps Required for Adventure: "+step2);
			}
			else
			{	
			  System.out.println("No Solution");
			  System.out.println("MinimumNumber of Steps Required for Monster: "+step3);
			}
			break;
		case 3:
			System.out.print("Enter the Number of Rows: ");
			int row3=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col3=sc.nextInt();
			char arr3[][]=new char[row3][col3];
			fillArray(arr3,row3,col3);
			System.out.print("Enter the Position of Adventure: ");
			int advRow3=sc.nextInt();
			int advCol3=sc.nextInt();
			arr3[advRow3-1][advCol3-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow3=sc.nextInt();
			int goldCol3=sc.nextInt();
			arr3[goldRow3-1][goldCol3-1]='G';
			

			System.out.print("Enter the Position of Monster: ");
			int monRow3=sc.nextInt();
			int monCol3=sc.nextInt();
			arr3[monRow3-1][monCol3-1]='M';

			display(arr3,row3,col3);
			List<int[]> adventurePath3 = new ArrayList<>();
			List<int[]> monsterPath3 = new ArrayList<>();
			
			int step4=minStepToGold(row3,col3,advRow3-1,advCol3-1,goldRow3-1,goldCol3-1,arr3,adventurePath3,1); 
			int step5=minStepToGold(row3,col3,monRow3-1,monCol3-1,goldRow3-1,goldCol3-1,arr3,monsterPath3,0)+1;


         		if(step4<step5)
			{
			   System.out.println("MinimumNumber of Steps Required for Adventure: "+step4);
			   for(int[] step : adventurePath3) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			}
			else
			{	
			  System.out.println("No Solution");
			  step5-=1;
			  System.out.println("MinimumNumber of Steps Required for Monster: "+step5);
			}

			break;
		case 4:
			System.out.print("Enter the Number of Rows: ");
			int row4=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col4=sc.nextInt();
			char arr4[][]=new char[row4][col4];
			fillArray(arr4,row4,col4);
			System.out.print("Enter the Position of Adventure: ");
			int advRow4=sc.nextInt();
			int advCol4=sc.nextInt();
			arr4[advRow4-1][advCol4-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow4=sc.nextInt();
			int goldCol4=sc.nextInt();
			arr4[goldRow4-1][goldCol4-1]='G';
			

			System.out.print("Enter the Position of Monster: ");
			int monRow4=sc.nextInt();
			int monCol4=sc.nextInt();
			arr4[monRow4-1][monCol4-1]='M';

			System.out.print("Enter the Position of Trigger: ");
			int triRow4=sc.nextInt();
			int triCol4=sc.nextInt();
			arr4[triRow4-1][triCol4-1]='T';

			

			display(arr4,row4,col4);
			List<int[]> adventurePath4 = new ArrayList<>();
			List<int[]> monsterPath4 = new ArrayList<>();
			List<int[]> triggerPath4 = new ArrayList<>();
			
			int step6=minStepToGold(row4,col4,advRow4-1,advCol4-1,goldRow4-1,goldCol4-1,arr4,adventurePath4,1); 
			int step7=minStepToGold(row4,col4,monRow4-1,monCol4-1,goldRow4-1,goldCol4-1,arr4,monsterPath4,0)+1;
			
			System.out.println("Steps For Adventure: "+step6);
			int var=step7-1;
			System.out.println("Steps for Monster: "+var);

         		if(step6<step7)
			{
			   System.out.println("MinimumNumber of Steps Required for Adventure: "+step6);
			   for(int[] step : adventurePath4) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			}
			else
			{	
			 int step8=minStepToGold(row4,col4,advRow4-1,advCol4-1,triRow4-1,triCol4-1,arr4,adventurePath4,1); 
			 int step9=minStepToGold(row4,col4,triRow4-1,triCol4-1,goldRow4-1,goldCol4-1,arr4,triggerPath4,1);
			System.out.println("Steps for Adventure to Trigger: "+step8);
			System.out.println("Steps for Trigger to Gold: "+step9);
		     	for(int[] step : adventurePath4) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			System.out.println();
			 for(int[] step : triggerPath4) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }  
			
			  int ans=step8+step9;
			  System.out.println("MinimumNumber of Steps Required: "+ans);
			}
			break;
		case 5:
			System.out.print("Enter the Number of Rows: ");
			int row5=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col5=sc.nextInt();
			char arr5[][]=new char[row5][col5];
			fillArray(arr5,row5,col5);

			System.out.print("Enter the Position of Adventure: ");
			int advRow5=sc.nextInt();
			int advCol5=sc.nextInt();
			arr5[advRow5-1][advCol5-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow5=sc.nextInt();
			int goldCol5=sc.nextInt();
			arr5[goldRow5-1][goldCol5-1]='G';
		
			 System.out.print("Enter the number of pits: ");
     			 int numPits = sc.nextInt();
        		for(int i=0;i<numPits;i++)
	 		 {
            		  System.out.print("Position of pit " +(i + 1) + ": ");
           		  int pitRow = sc.nextInt();
          		  int pitCol = sc.nextInt();
           		  arr5[pitRow-1][pitCol-1] ='P';
        		 }
			display(arr5,row5,col5);
			List<int[]> adventurePath5 = new ArrayList<>();
			int step9=minStepToGold(row5,col5,advRow5-1,advCol5-1,goldRow5-1,goldCol5-1,arr5,adventurePath5,1); 

			if(step9!=Integer.MAX_VALUE)
			{ 
			System.out.println("MinimumNumber of Steps Required for Adventure: "+step9);
			}
			else
			{
			  System.out.println("No Solution");
			}
			System.out.println("---------------------------------");

			break;
		case 6:
			System.out.print("Enter the Number of Rows: ");
			int row6=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col6=sc.nextInt();
			char arr6[][]=new char[row6][col6];
			fillArray(arr6,row6,col6);
			System.out.print("Enter the Position of Adventure: ");
			int advRow6=sc.nextInt();
			int advCol6=sc.nextInt();
			arr6[advRow6-1][advCol6-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow6=sc.nextInt();
			int goldCol6=sc.nextInt();
			arr6[goldRow6-1][goldCol6-1]='G';
			

			System.out.print("Enter the Position of Monster: ");
			int monRow6=sc.nextInt();
			int monCol6=sc.nextInt();
			arr6[monRow6-1][monCol6-1]='M';

			 System.out.print("Enter the number of pits: ");
     			 int numPits4 = sc.nextInt();
        		for(int i=0;i<numPits4;i++)
	 		 {
            		  System.out.print("Position of pit " +(i + 1) + ": ");
           		  int pitRow4 = sc.nextInt();
          		  int pitCol4 = sc.nextInt();
           		  arr6[pitRow4-1][pitCol4-1] ='P';
        		 }
			display(arr6,row6,col6);

			

			List<int[]> adventurePath6 = new ArrayList<>();
			List<int[]> monsterPath6 = new ArrayList<>();
			List<int[]> triggerPath6 = new ArrayList<>();
			
			int steps1=minStepToGold(row6,col6,advRow6-1,advCol6-1,goldRow6-1,goldCol6-1,arr6,adventurePath6,1); 
			int steps2=minStepToGold(row6,col6,monRow6-1,monCol6-1,goldRow6-1,goldCol6-1,arr6,monsterPath6,0)+1;
			
			System.out.println("Steps For Adventure: "+steps2);
			int var3=steps2-1;
			System.out.println("Steps for Monster: "+var3);
                        if(steps1!=Integer.MAX_VALUE)
			{
         		 if(steps1<steps2)
			  {
			    System.out.println("MinimumNumber of Steps Required for Adventure: "+steps1);
			    for(int[] step : adventurePath6) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			}
			else
			{	
			   System.out.println("No SOlution");
			}
		     }
		else
		  {
		 	 System.out.println("NO Solution");
                  }
			break;
		case 7:
			System.out.print("Enter the Number of Rows: ");
			int row7=sc.nextInt();
			System.out.print("Enter the Number of Coloumn: ");
			int col7=sc.nextInt();
			char arr7[][]=new char[row7][col7];
			fillArray(arr7,row7,col7);
			System.out.print("Enter the Position of Adventure: ");
			int advRow7=sc.nextInt();
			int advCol7=sc.nextInt();
			arr7[advRow7-1][advCol7-1]='A';

			System.out.print("Enter the Position of Gold: ");
			int goldRow7=sc.nextInt();
			int goldCol7=sc.nextInt();
			arr7[goldRow7-1][goldCol7-1]='G';
			

			System.out.print("Enter the Position of Monster: ");
			int monRow7=sc.nextInt();
			int monCol7=sc.nextInt();
			arr7[monRow7-1][monCol7-1]='M';

			System.out.print("Enter the Position of Trigger: ");
			int triRow7=sc.nextInt();
			int triCol7=sc.nextInt();
			arr7[triRow7-1][triCol7-1]='T';
			
			 System.out.print("Enter the number of pits: ");
     			 int numPits1 = sc.nextInt();
        		for(int i=0;i<numPits1;i++)
	 		 {
            		  System.out.print("Position of pit " +(i + 1) + ": ");
           		  int pitRow1 = sc.nextInt();
          		  int pitCol1 = sc.nextInt();
           		  arr7[pitRow1-1][pitCol1-1] ='P';
        		 }
			

			display(arr7,row7,col7);
			List<int[]> adventurePath7 = new ArrayList<>();
			List<int[]> monsterPath7 = new ArrayList<>();
			List<int[]> triggerPath7 = new ArrayList<>();
			
			int st1=minStepToGold(row7,col7,advRow7-1,advCol7-1,goldRow7-1,goldCol7-1,arr7,adventurePath7,1); 
			int st2=minStepToGold(row7,col7,monRow7-1,monCol7-1,goldRow7-1,goldCol7-1,arr7,monsterPath7,0)+1;
			
			System.out.println("Steps For Adventure: "+st1);
			int var1=st2-1;
			System.out.println("Steps for Monster: "+var1);

         		if(st1<st2)
			{
			   System.out.println("MinimumNumber of Steps Required for Adventure: "+st1);
			   for(int[] step : adventurePath7) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			}
			else
			{	
			 int st3=minStepToGold(row7,col7,advRow7-1,advCol7-1,triRow7-1,triCol7-1,arr7,adventurePath7,1); 
			 int st4=minStepToGold(row7,col7,triRow7-1,triCol7-1,goldRow7-1,goldCol7-1,arr7,triggerPath7,0);
			System.out.println("Steps for Adventure to Trigger: "+st3);
			System.out.println("Steps for Trigger to Gold: "+st4);
			for(int[] step : adventurePath7) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			System.out.println();
			 for(int[] step : triggerPath7) 
	                     {
                		System.out.println(Arrays.toString(step));
            		     }
			
			  int ans1=st3+st4;
			  if(st3!=Integer.MAX_VALUE && st4!=Integer.MAX_VALUE)
			   {
			      System.out.println("MinimumNumber of Steps Required: "+ans1);
			   }
			  else
			   {
				System.out.println("No Solution");
			   }
			}

			break;
		case 8:
			System.out.println("Exiting the Console");
			check=false;
			break;
		default:
			System.out.println("Invalid Choice");
			break;

	  }
	}
 }
}