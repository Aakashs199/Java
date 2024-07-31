/* 22. Find Winner on a Tic Tac Toe Game

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

Example 1:

[[X,-,-],
 [-,X,-],
 [O,O,X]]

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:

[[X,X,O],
 [X,O,-],
 [O,-,-]]

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:

[[X,X,O],
 [O,O,X],
 [X,O,X]]

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.

Constraints:

1 <= moves.length <= 9
moves[i].length == 2
0 <= rowi, coli <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.

https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/    */

import java.util.*;
public class TicTakToe
{

public static char checkWinner(char arr[][])
{
 


  for(int i=0;i<3;i++)
   {
     int rowCountA=0;
     int rowCountB=0;
     int colCountA=0;
     int colCountB=0;
     int digCountA=0;
     int digCountB=0;
     for(int j=0;j<3;j++)
	{
	  if(arr[i][j]=='X')
	   {
	     rowCountA++;
	   }
	  if(arr[i][j]=='O')
	   {
		rowCountB++;
	   }

	if(arr[j][i]=='X')
	   {
	     colCountA++;
	   }
	  if(arr[i][j]=='O')
	   {
		colCountB++;
	   }
   
         if(i==j)
          {
             if(arr[j][i]=='X')
	     {
	       digCountA++;
	     }
	    if(arr[i][j]=='O')
	      {
		digCountB++;
	      }
          }
	  
	}
    if(rowCountA==3 || colCountA==3 ||digCountA==3)
      {
	return 'A';
      }
    if(rowCountB==3 || colCountB==3 ||digCountB==3)
      {
         return 'B';
      }
   }



return 'C';

}



public static void display(char arr[][])
{
  for(int i=0;i<3;i++)
       {
            for(int j=0;j<3;j++)
		{
		   System.out.print(arr[i][j]+" ");
		}
	   System.out.println();
       }
}


public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    char arr[][]=new char[3][3];
    for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
	     {
	         arr[i][j]='-';
	   }
       }
    display(arr);   
    System.out.print("Enter the Number of Steps: ");
    int move=sc.nextInt();
    int moves[][]=new int[move][move];
    for(int i=0;i<move;i++)
       {
             moves[i][0]=sc.nextInt();
	     moves[i][1]=sc.nextInt();
       }
    for(int i=0;i<move;i++)
       {
         if(i%2==1)
 	   {
             arr[moves[i][0]][moves[i][1]]='O';
           }
	  else
	   {
		arr[moves[i][0]][moves[i][1]]='X';
	   }
	  
       }
    display(arr);
    char ans=checkWinner(arr);
    if(ans=='C')
    {
      System.out.println("Match is Draw");
    }
    else
    {
      System.out.println("Player "+ans+" Wins the Game");
     }

}
}