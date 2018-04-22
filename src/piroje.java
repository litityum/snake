import java.util.*;
import java.io.*;

public class piroje {
	//A final array that stores pieces
	public static final String[] piece = {"BTSS", "BTSH", "BTRS", "BTRH", "BSSS", "BSSH", "BSRS", "BSRH",
			"WTSS", "WTSH", "WTRS", "WTRH", "WSSS", "WSSH", "WSRS", "WSRH"};

	public static void main(String[] args) throws FileNotFoundException {
		//A Scanner to get user's input
		Scanner console = new Scanner(System.in);
		
		System.out.println("Welcome to the \"Weird Game\"!");
		System.out.println("Press 1 to load input.txt");
		System.out.println("Press anything else to start a new game");
		//A string to choose whether load a game or start a new game
		String press = console.nextLine();
		//A file to load a game
		File input = new File("input.txt");
		//A String array for board
		String[][] board;
		//An if statement to load a game or start a new game
		if (press.equals("1")) {
			//An if statement to check whether file exists or not
			if(input.exists()) {
				//Scanning input.txt
				board = scanFile(input);
				//An if statement to check whether the game has already finished or not
				if (winCheck(board)) {

					System.out.println("This game has already finished!");
					//if the game is finished, ends the program
					return;
				}

				System.out.println("Your on-going game");
			}

			else {
				System.out.println("There is not any on-going game.");
				//if there is not any game, crates new board
				board = emptyBoard();

				System.out.println("Your empty board:");
				
			}
			
		}

		else {
			//crates new board
			board = emptyBoard();

			System.out.println("Your empty board:");

		}
		
		
		//printing board
		print(board);

		
		//A string to pick a piece
		String picked;
		//An array to take coordinates from the user
		int [] squares = new int [2];
		//A while loops until there is not any Empty place
		while (emptyCounter(board) != 0) {
			//An if statement to decide whose turn
			if(emptyCounter(board) % 2 == 0) {
				//User's choosing piece
				picked = pieceChoose(console, board);
				//Computer's placing the piece
				newCompMove1(board, picked, 20);
				//printing the board
				print(board);
				//An if statement to check the game is finished or not
				if (winCheck(board)) {

					System.out.println("You lost!");
					//if the game is ended, ends the program
					return;
				}

				System.out.println("If you want to quit and save your game, press 1.");
				System.out.println("If you don't, press anything else.");
				//A string to get user's input about quitting
				String quit = console.nextLine();
				//An if statement to quit game
				if(quit.equals("1")) {
					//A PrintStream to save the game
					PrintStream stream = new PrintStream("input.txt");
					//Saving the game
					save(board, stream);
					//closing the PrintStream
					stream.close();
					//Ending the game
					return;
					
				}
				
			}
			//An if statement to decide whose turn
			if(emptyCounter(board) % 2 == 1) {
				//Comp's choosing a piece
				String compMove = newCompMove2(board, 20);

				System.out.println("Comp's piece is: " + compMove);
				System.out.println("Which square do you want to choose?");
				//User's coordinates to put the piece
				squares = squareChoose(console, board);
				//putting the piece
				board[squares[0]][squares[1]] = compMove;
				//printing the board
				print(board);
				//An if statement to check the game is finished or not
				if (winCheck(board)) {

					System.out.println("You won!");
					//if the game is ended, ends the program
					return;
				}

				System.out.println("If you want to quit and save your game, press 1.");
				System.out.println("If you don't, press anything else.");
				//A string to get user's input about quitting
				String quit = console.nextLine();
				//An if statement to quit game
				if(quit.equals("1")) {
					//A PrintStream to save the game
					PrintStream stream = new PrintStream("input.txt");
					//Saving the game
					save(board, stream);
					//closing the PrintStream
					stream.close();
					//Ending the game
					return;
					
				}
				
			}

			
		}
		System.out.println("There is a tie!");

	}
	//A method to print the board
	public static void print(String[][] board) {
		//A for statement to traverse the board and to print it
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				
				System.out.print(board[i][j] + "\t");

			}

			System.out.println();
		}
	}
	//A method for Comp's placing the piece
	public static void compMove1(String[][] board, String picked) {
		//A Random object to get random index
		Random rand = new Random();
		//A for statement to traverse the board
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				 
				if (board[i][j].equals("E")) {
					//placing the piece if this place is empty
					board[i][j] = picked;
					
					if (winCheck(board))
						//if it is winning move, then ends the method
						return;

					else
						//if it is not, takes the move back
						board[i][j] = "E";
				}
			}
		}
		//An integer that equals Empty places on the board
		int count = emptyCounter(board);
		// a random to choose one of these empty places
		int random = rand.nextInt(count) + 1;
		
		count = 0;
		//A for statement to traverse the board
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				//An if statement to count the empty places
				if (board[i][j].equals("E")) {

					count++;
					//An if statement to choose correct place
					if (count == random) {
						//placing the piece this place
						board[i][j] = picked;
						//ending the method
						return;
					}

				}
			}
		}

	}
	//A method for Comp's choosing a piece
	public static String compMove2(String[][] board) {
		//A Random object to get random piece
		Random rand = new Random();
		//A for statement to traverse the pieces	
		for (int i = 0; i < 16; i++) {
			//if piece is not on the board and it isn't a winning piece, returns it
			if (replaceAndCheck(board, piece[i])) return piece[i];
			
		}
		//a boolean to check a piece is usable or not
		boolean flag = true;
		//a while statement that loops until a piece is chosen
		while(true) {
			//A random integer to choose random piece
			int k = rand.nextInt(16);
			
			for (int i = 0; i < 4; i++) {

				for (int j = 0; j < 4; j++) {
					//if the random piece is already on the board changes the flag to false
					if (piece[k].equals(board[i][j]))
						flag = false;
				}
			}
			//otherwise returns the piece
			if (flag)
				return piece[k];
			//returns the flag true back if the piece isn't returned
			flag = true;
		}

		
	}
	//A method to scan file
	public static String[][] scanFile(File input) throws FileNotFoundException {
		//A scanner to scan input.txt
		Scanner sc = new Scanner(input);
		//An array to scan input.txt
		String[][] board = new String[4][4];
		//A for statement to traverse the board
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				
				board[i][j] = sc.next();
			}
		}	
		//Closing Scanner
		sc.close();
		//Returns the board
		return board;
	}
	//A method to crate an empty board
	public static String[][] emptyBoard() {
		//An array for board
		String[][] board = new String[4][4];
		//A for statement to traverse the board
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {

				board[i][j] = "E";
			}
		}
		//returns the empty board
		return board;
	}
	//A method to check whether there is a win situation or not
	public static boolean winCheck(String[][] board) {
		//Counters for the same characters
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		//chars to compare
		char char0 = ' ';
		char char1 = ' ';
		char char2 = ' ';
		char char3 = ' ';
		//A for statement to check is there any ended rows
		for (int i = 0; i < 4; i++) {
			//if the first place of the i. row is not empty takes it's chars
			if (!board[i][0].equals("E")) {
				
				char0 = board[i][0].charAt(0);
				char1 = board[i][0].charAt(1);
				char2 = board[i][0].charAt(2);
				char3 = board[i][0].charAt(3);

			}
			for (int j = 0; j < 4; j++) {
				//if there is any empty place, just breaks
				if (board[i][j].equals("E"))
					break;
				//if there is any char equal to first piece, counts it
				if (char0 == board[i][j].charAt(0))
					count0++;
				if (char1 == board[i][j].charAt(1))
					count1++;
				if (char2 == board[i][j].charAt(2))
					count2++;
				if (char3 == board[i][j].charAt(3))
					count3++;

			}
			//if one of the chars at the same indexes are the same, returns true
			if (count0 == 4 || count1 == 4 || count2 == 4 || count3 == 4)
				return true;
			// resets the counts and chars
			count0 = 0;
			count1 = 0;
			count2 = 0;
			count3 = 0;

			char0 = ' ';
			char1 = ' ';
			char2 = ' ';
			char3 = ' ';
		}
		//Does the same things for columns
		for (int j = 0; j < 4; j++) {

			if (!board[0][j].equals("E")) {

				char0 = board[0][j].charAt(0);
				char1 = board[0][j].charAt(1);
				char2 = board[0][j].charAt(2);
				char3 = board[0][j].charAt(3);

			}

			for (int i = 0; i < 4; i++) {

				if (board[i][j].equals("E"))
					break;

				if (char0 == board[i][j].charAt(0))
					count0++;
				if (char1 == board[i][j].charAt(1))
					count1++;
				if (char2 == board[i][j].charAt(2))
					count2++;
				if (char3 == board[i][j].charAt(3))
					count3++;
			}
			if (count0 == 4 || count1 == 4 || count2 == 4 || count3 == 4)
				return true;

			count0 = 0;
			count1 = 0;
			count2 = 0;
			count3 = 0;

			char0 = ' ';
			char1 = ' ';
			char2 = ' ';
			char3 = ' ';
		}
		//An if statement to check first element of the first diagonal is empty or not
		if (!board[0][0].equals("E")) {
			//if not, takes its chars
			char0 = board[0][0].charAt(0);
			char1 = board[0][0].charAt(1);
			char2 = board[0][0].charAt(2);
			char3 = board[0][0].charAt(3);
			//A for statement to traverse the diagonal
			for (int i = 0; i < 4; i++) {
				//if there is any empty place, just breaks
				if (board[i][i].equals("E"))
					break;
				//if there is any char equal to first piece, counts it
				if (char0 == board[i][i].charAt(0))
					count0++;
				if (char1 == board[i][i].charAt(1))
					count1++;
				if (char2 == board[i][i].charAt(2))
					count2++;
				if (char3 == board[i][i].charAt(3))
					count3++;
			}
			//if one of the chars at the same indexes are the same, returns true
			if (count0 == 4 || count1 == 4 || count2 == 4 || count3 == 4)
				return true;
			// resets the counts and chars
			count0 = 0;
			count1 = 0;
			count2 = 0;
			count3 = 0;

			char0 = ' ';
			char1 = ' ';
			char2 = ' ';
			char3 = ' ';

		}
		//Does the same things for the other diagonal
		if (!board[3][0].equals("E")) {

			char0 = board[3][0].charAt(0);
			char1 = board[3][0].charAt(1);
			char2 = board[3][0].charAt(2);
			char3 = board[3][0].charAt(3);

			for (int i = 0; i < 4; i++) {

				if (board[3 - i][i].equals("E"))
					break;

				if (char0 == board[3 - i][i].charAt(0))
					count0++;
				if (char1 == board[3 - i][i].charAt(1))
					count1++;
				if (char2 == board[3 - i][i].charAt(2))
					count2++;
				if (char3 == board[3 - i][i].charAt(3))
					count3++;
			}

			if (count0 == 4 || count1 == 4 || count2 == 4 || count3 == 4)
				return true;

			count0 = 0;
			count1 = 0;
			count2 = 0;
			count3 = 0;

			char0 = ' ';
			char1 = ' ';
			char2 = ' ';
			char3 = ' ';

		}

		return false;
	}
	//A method to prevent Comp's giving a winning piece
	public static boolean replaceAndCheck(String[][] board, String picked) {
		//A nested for to check the piece is on the board or not
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				//if the piece is already on the board, returns false
				if (board[i][j].equals(picked)) {
					return false;
				}
			}
		}
		//A nested for to check if Comp puts the piece an empty square, is it winning or not
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {

				if (board[i][j].equals("E")) {

					board[i][j] = picked;
					//if it is winning, returns false
					if (winCheck(board)) {

						board[i][j] = "E";

						return false;
					}
					//Takes the move back if it doesn't return anything
					board[i][j] = "E";
				}
			}
		}
		//if it is'n winning piece, returns true
		return true;

	}
	//A method to check user's piece is available or not
	public static boolean pickedCheck(String picked, String[][] board) {
		//if the piece is already on the board, it returns false
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {

				if (board[i][j].equals(picked))
					return false;
			}
		}
		//if the piece is one of the valid pieces, returns true
		for (int i = 0; i < 16; i++) {

			if (picked.equals(piece[i]))
				return true;
		}
		//otherwise returns false
		return false;
	}
	//A method for user's piece choosing
	public static String pieceChoose(Scanner console, String[][] board) {
		//Shows the available pieces
		boslariGoster(board);
		System.out.println("Choose a piece");
		//A string to take user's piece
		String picked = console.nextLine().toUpperCase();
		//Takes user's piece while it is not available
		while (!pickedCheck(picked, board)) {

			System.out.println("Invalid or already used piece");
			System.out.println("Please choose the piece again:");

			picked = console.nextLine().toUpperCase();
		}
		//returns the user's piece
		return picked;
	}
	//A method for user's place choosing
	public static int [] squareChoose(Scanner console, String[][] board) {
		//Taking user's input
		String square = console.nextLine();
		//integers to take i and j coordinates
		int square1;
		int square2;
		//Takes user's coordinates while the input is not in requested form
		while (square.length() > 3 || square.length() < 3 || square.charAt(1) != ' ') {
			
			System.out.println("Be sure that your input must be like this \"2 0\".");
			//takes the input again
			square = console.nextLine();
		}
		//Takes the integer values of the inputs
		square1 = square.charAt(0) - 48;
		square2 = square.charAt(2) - 48;
		//Takes user's coordinates while the coordinates are not in the requested gap
		while(square1 > 3 || square2 > 3 || square1 < 0 || square2 < 0) {
			
			System.out.println("Your coordinates must be 0, 1, 2, 3 .");
			System.out.println("Which square do you want to choose?");

			square = console.nextLine();
			//Takes user's coordinates while the input is not in requested form
			while (square.length() > 3 || square.length() < 3 || square.charAt(1) != ' ') {

				System.out.println("Be sure that your input must be like this \"2 0\".");

				square = console.nextLine();
			}
			//Takes the integer values of the inputs
			square1 = square.charAt(0) - 48;
			square2 = square.charAt(2) - 48;
			
		}
		//Does the same things while the chosen square is not empty
		while (!board[square1][square2].equals("E")) {

			System.out.println("This square is not empty.");
			System.out.println("Pleas choose another square.");

			square = console.nextLine();

			while (square.length() > 3 || square.length() < 3 || square.charAt(1) != ' ') {

				System.out.println("Be sure that your input must be like this \"2 0\".");

				square = console.nextLine();
			}

			square1 = square.charAt(0) - 48;
			square2 = square.charAt(2) - 48;
			
			while(square1 > 3 || square2 > 3 || square1 < 0 || square2 < 0) {
				
				System.out.println("Your coordinates must be 0, 1, 2, 3 .");
				System.out.println("Which square do you want to choose?");

				square = console.nextLine();

				while (square.length() > 3 || square.length() < 3 || square.charAt(1) != ' ') {

					System.out.println("Be sure that your input must be like this \"2 0\".");

					square = console.nextLine();
				}

				square1 = square.charAt(0) - 48;
				square2 = square.charAt(2) - 48;
				
			}
			
		}
		//returning the coordinates
		int [] squares = new int [2];
		
		squares[0] = square1;
		squares[1] = square2;
		
		return squares;
		
	}
	//A method to count empty places
	public static int emptyCounter(String [][] board) { 
		//counter for this
		int emptyCounter = 0;
		
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				//counts if the place is empty
				if (board[i][j].equals("E")) {

					emptyCounter++;
				}
			}
		}
		//returns the count of the empty places
		return emptyCounter;
		
	}
	//A method to save the game
	public static void save(String[][] board, PrintStream stream) {
		//A nested for to traverse the board
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				//printing them to the board
				stream.print(board[i][j] + "\t");

			}

			stream.println();
		}
		
		System.out.println("Saving is done!");
	}
	//A method to show the available pieces
	public static void boslariGoster(String [][] board) {
		//A boolean array to store pieces availability
		boolean [] arr = new boolean[16];
		//Fills the array
		for(int i = 0; i < 16; i++) arr[i] = true;
		//Checks the board for every piece
		for(int m = 0; m < 16; m++) {
			
			for (int i = 0; i < 4; i++) {

				for (int j = 0; j < 4; j++) {
					//if the piece is already on the board, array in the same index takes the value false
					if (board[i][j].equals(piece[m])) {
						
						arr[m] = false;
						
					}
				}
			}
			
		}
		//Printing the available pieces
		System.out.println("These are the pieces you can use: ");
		for(int i = 0; i < 8; i++) {
			if(arr[i])
			System.out.print(piece[i] + " ");
		}
		System.out.println();
		for(int i = 8; i < 16; i++) {
			if(arr[i])
			System.out.print(piece[i] + " ");
		}
		System.out.println();
	}
	//Rest of the methods make comp able to play 10 games by itself and decide which move is more rational
	//A method to decide how rational to take a piece
	public static int neKadarMantikli(String [][] board, String picked, int N) {
		//A counter to count how many games the comp wins
		int count = 0;
		//A clone board
		String [][] board2 = new String [4][4];
		//Cloning the board
		for(int i = 0; i < 4; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				board2[i][j] = board[i][j];
			}
		}
		//A for statement to play N games by itself
		for(int game = 0; game < N; game++) {
			//An integer to count the turns
			int turn = 0;
			//Reseting the clone board
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					board2[i][j] = board[i][j];
				}
			}
			//Second player plays the move
			compMove1(board2, picked);
			
			if(winCheck(board2)) {
				//if there is a winning move, to the next game!
				continue;
			}
			//Otherwise, plays until the game ends
			while(emptyCounter(board2) != 0) {
				//An if statement to decide whose turn
				if(turn % 2 == 0) {
					//second player picks a piece
					picked = compMove2(board2);
					//first player plays its move
					compMove1(board2, picked);
					
					if(winCheck(board2)) {
						//if it is a winning move, count this game and to the next game!
						count++;
						break;
					}
					//to the next turn
					turn++;
				}
				else {
					//first player picks a piece
					picked = compMove2(board2);
					//second player plays its move
					compMove1(board2, picked);
					
					if(winCheck(board2)) {
						//if it is a winning move, to the next game!
						break;
					}
					//counts the turn
					turn++;
				}
			}
		}
		//returns how many games are won by the first player out of N games
		return count;
		
	}
	//An improved method to choose a piece
	public static String newCompMove2(String [][] board, int N) {
		//An integer to decide which move has the max. value
		int max = 0;
		//An array to decide the piece is on the board or not
		boolean [] arr = new boolean[16];
		//An array to store values of the pieces
		int [] array = new int [16];
		//Assigns the values of "arr" array
		for(int i = 0; i < 16; i++) arr[i] = pickedCheck(piece[i], board);
		//Determines the max value
		for(int m = 0; m < 16; m++) {
			if(arr[m]) {
				array[m] = neKadarMantikli(board, piece[m], N);
				if(max < array[m]) {
					max = array[m];
				}
			}
		}
		//Returns the piece which has the most value
		for(int i = 0; i < 16; i++) {
			
			if(arr[i]) {
				if(max == array[i]) {
					return piece[i];
				}
			}
		}
		//if it doesn't return anything, there must be a problem
		return "ops";
	}
	//An improved method to play the piece
	public static void newCompMove1(String [][] board, String picked, int N) {
		//An array to decide the place is empty or not
		boolean [][] arr = new boolean[4][4];
		//An array to store values of the places
		int [][] array = new int [4][4];
		//An integer to decide which move has the max. value
		int max = 0;
		//Assigns the values of "arr" array
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = board[i][j].equals("E");
			}
		}
		
		//Determines the max value by traversing the board
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				if(arr[i][j]) {
					array[i][j] = neKadarMantikli(board,picked, i, j, N);
					if(max < array[i][j])
						max = array[i][j];
				}
				
			}
			
		}
		//Plays the move with the max value
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(arr[i][j]) {
					if(max == array[i][j]) {
						board[i][j] = picked;
						//After playing this move, ends the method
						return;
					}
						
				}
				
			}
		}
		
		
		
		
	}
	//A method to decide how rational to play a piece to board[m][n]
	public static int neKadarMantikli(String [][] board, String picked, int m, int n, int N) {
		//A counter to count how many games the comp wins
		int count = 0;
		//A for statement to play N games by itself
		for(int game = 0; game < N; game++) {
			//An integer to count the turns
			int turn = 0;
			//A clone board
			String [][] board2 = new String [4][4];
			//Cloning the board
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					board2[i][j] = board[i][j];
				}
			}
			//first player plays the move
			board2[m][n] = picked;
			
			if(winCheck(board2)) {
				//if it is a winning move, count this game and to the next game!
				count++;
				continue;
			}
			//If the game is ended, just break the loop
			if(emptyCounter(board2) == 0)
				break;
			//first player chooses a piece
			picked = compMove2(board2);
			//The game is being played until the game ends
			while(emptyCounter(board2) != 0) {
				//An if statement to decide whose turn
				if(turn % 2 == 1) {
					//counts the turn
					turn++;
					//first player places the piece
					compMove1(board2, picked);
					//if it is a winning move count this game and break the loop
					if(winCheck(board2)) {
						count++;
						break;
					}
					//If the game is ended, just break the loop
					if(emptyCounter(board2) == 0)
						break;
					picked = compMove2(board2);
					//If the game is ended, just break the loop
					if(emptyCounter(board2) == 0)
						break;
				
					
				}
				
				else {
					//counts the turn
					turn++;
					//If the game is ended, just break the loop
					if(emptyCounter(board2) == 0)
						break;
					//second player places the piece
					compMove1(board2, picked);
					//if it is a winning move, break the loop
					if(winCheck(board2)) {
						break;
					}
					//If the game is ended, just break the loop
					if(emptyCounter(board2) == 0)
						break;
					//otherwise second player chooses a piece
					picked = compMove2(board2);
					
					
				}
			}
		}
		//returns the value of a move
		return count;
	}
	
}


