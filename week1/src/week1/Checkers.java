//Programmer: Alison Davis
//Programmed: 01.02.18
//Purpose: Allow checker game play back and forth without letting either player
//select an invalid piece or enter an invalid movement location. No jumping has
//been programmed at this time.

package week1;

import java.util.Scanner;
public class Checkers {

	public static void main(String[] args) {
		char[][] board = new char [20][23];
		
		for(int i = 0; i < 20; i++)
		{
			for (int p = 0; p < 23; p++)
			{
				board[i][p] = ' ';
			}
		}

		//Generate player 1 setup

		for(int q = 4; q < 9 ; q+=4)
		{
			for(int a = 5; a< 18; a += 4)
			{
				board[a][q] = '1';
			}
		}
		
		{

		board[3][6] = '1';
		board[7][6] = '1';
		board[11][6] = '1';
		board[15][6] = '1';
		}
		//Generate plater 2 setup
		
		for(int a = 3; a < 16; a+=4)
		{
			board[a][14] = '2';
			board[a][18] = '2';
		}
		
		{

		board[5][16] = '2';
		board[9][16] = '2';
		board[13][16] = '2';
		board[17][16] = '2';
		}
	
		//Generate number grid setup
		board[3][2] = '0';
		board[5][2] = '1';
		board[7][2] = '2';
		board[9][2] = '3';
		board[11][2] = '4';
		board[13][2] = '5';
		board[15][2] = '6';
		board[17][2] = '7';
		
		board[0][4] = '0';
		board[0][6] = '1';
		board[0][8] = '2';
		board[0][10] = '3';
		board[0][12] = '4';
		board[0][14] = '5';
		board[0][16] = '6';
		board[0][18] = '7';
		
		board[2][3] = '+';
		board[19][3] = '+';
		board[2][19] = '+';
		board[19][19] = '+';
	
		//Generate Borders
		for(int x = 3; x < 19; x++)
		{
			board[x][3] = '-';
			board[x][19] = '-';
		}
		
		for(int y = 4; y < 19; y++)
		{
			board[2][y] = '|';
			board[19][y] = '|';
		}
		
		System.out.println("Welcome to virtual checkers!");
		
		//Print out the board
		for(int i = 0; i < 23; i++)
		{
			for (int p = 0; p < 20; p++)
			{
				if(p < 19)
				{
				System.out.print(board[p][i]);
				}
				else if(p == 19)
				{
					System.out.print(board[p][i] + "\n"); 
				}
			}

		}
		
		//Initialize playerNum and boolean proceed
		char playerNum = '1';
		boolean proceed = false;
		int inputx = 0;
		int inputy = 0;
		Scanner s = new Scanner(System.in);
		
		//Keep looping this part
		while(true)
		{
			System.out.println("Your turn Player " + playerNum);
			//Get user input for what piece they would like to move

		while(proceed == false)
		{
		System.out.println("Please enter x coordinate of piece you want to move: ");
		inputx = s.nextInt();
		System.out.println("Please enter y coordinate of piece you want to move: ");
		inputy = s.nextInt();
		
		//FIX FOR PLAYER 1 to not choose a piece with no available movement
		if(playerNum == '1')
		{
			//Account for where the piece can go and rule out the spaces off the edges of the board
			//Make sure piece at x = 0 can only move further in
			if(inputx - 1 == -1)
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && (board[2*(inputx+1)+3][2*(inputy+1)+4] == ' ')) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			}
			
			//Make sure piece at x = 7 can only move further in
			else if(inputx + 1 == 8)
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && (board[2*(inputx-1)+3][2*(inputy+1)+4] == ' ')) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			}
			
			else
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && ((board[2*(inputx+1)+3][2*(inputy+1)+4] == ' ') ||(board[2*(inputx-1)+3][2*(inputy+1)+4] == ' ')) && ((inputx-1)>=0) && ((inputx+1) <8)) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			}
			
		}
		
		//FIX FOR player 2 to not choose a piece with no available movement
		else if(playerNum == '2')
		{
			if(inputx - 1 == -1)
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && (board[2*(inputx+1)+3][2*(inputy-1)+4] == ' ')) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			}
			
			else if(inputx + 1 == 8)
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && (board[2*(inputx-1)+3][2*(inputy+1)+4] == ' ')) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			}
			
			else
			{
				if((board[2*inputx + 3][2*inputy +4] == playerNum) && ((board[2*(inputx+1)+3][2*(inputy-1)+4] == ' ') ||(board[2*(inputx-1)+3][2*(inputy-1)+4] == ' ')) && ((inputx-1)>=0) && ((inputx+1) <8)) 
				{
					proceed = true;
				}
				else
				{
					System.out.println("Invalid piece selection. Please try again.");
					//Proceed stays false
				}
			
			}
		}

		} //End piece selection 1
		
		
		proceed = false;
		while(proceed == false)
		{
		System.out.println("Please enter x coordinate of where you want to move piece to: ");
		int movex = s.nextInt();
		//movex = 2 * movex +4;
		System.out.println("Please enter y coordinate of where you want to move piece to: ");
		int movey = s.nextInt();
		//movey = 2 * movey +3;
		
		if(playerNum == '1')
		{
			if((movey == inputy + 1) && ((movex == inputx +1) || (movex == inputx - 1)) && (movex >= 0) && (movex < 8))
			{
				if (board[2 * movex +3][2*movey +4] == ' ')
				{
					proceed = true;
					board[2 * movex +3][2*movey +4] = '1';
					board[2 * inputx +3][2*inputy +4] = ' ';
				}
				
			}
			else
			{
				proceed = false;
				System.out.println("Invalid movement please try again.");
			}
		}
		
		else if(playerNum == '2')
		{
			if((movey == inputy - 1) && ((movex == inputx +1) || (movex == inputx - 1)) && (movex >= 0) && (movex < 8))
			{
				if (board[2 * movex +3][2*movey +4] == ' ')
				{
					proceed = true;
					board[2 * movex +3][2*movey +4] = '2';
					board[2 * inputx +3][2*inputy +4] = ' ';
				}
				
			}
			else
			{
				proceed = false;
				System.out.println("Invalid movement please try again.");
			}
		}
		}
		
		//print board
		for(int i = 0; i < 23; i++)
		{
			for (int p = 0; p < 20; p++)
			{
				if(p < 19)
				{
				System.out.print(board[p][i]);
				}
				else if(p == 19)
				{
					System.out.print(board[p][i] + "\n"); 
				}
			}

		}
		//Before restarting loop change player and reset proceed to false
		proceed = false;
		if(playerNum == '1')
		{
			playerNum = '2';
		}
		else
		{
			playerNum = '1';
		}
		}
		
		
	}
}


