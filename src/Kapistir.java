import java.util.*;
import java.io.*;
public class Kapistir {
	
	public static int run(int t) {
		String [][] board = new String[4][4];
		Random rand = new Random();
		
		board = piroje.emptyBoard();
		//piroje.print(board);
		//System.out.println();
		String picked;
		while(piroje.emptyCounter(board) != 0) {
			if(piroje.emptyCounter(board) %2 == t) {
//				if(piroje.winCheck(board)) {
//					System.out.println("Ramizinki yendi");
//					piroje.print(board);
//					return;
//				}
				//picked = piroje.newCompMove2(board, 5);
				picked = Ramiz.arrayToString(Ramiz.givePiece(Stringtoint(board)));
				//picked = Game.api_choose(board);
				//System.out.println("Bunu Ömer Koyacak " + picked);
				piroje.newCompMove1(board, picked, 10);
				//piroje.print(board);
				
//				System.out.println(piroje.winCheck(board));
				if(piroje.winCheck(board)) {
					
					
					//System.out.println("Ömerinki yendi");
//					piroje.print(board);
					return 1;
				}
			}
			else {
				picked = piroje.newCompMove2(board, 10);
				//piroje.newCompMove1(board, picked, 5);
				board = intToString(Ramiz.playPiece(Stringtoint(board), picked));
				//System.out.println("Bunu Ramiz Koyacak" + picked);
				//Game.api_play(board, picked);
				//piroje.print(board);
				
//				System.out.println(piroje.winCheck(board));
				if(piroje.winCheck(board)) {
					//System.out.println("Ramizinki yendi");
//					piroje.print(board);
					return 2;
				}
				
				
			}
//			piroje.print(board);
//			System.out.println(piroje.emptyCounter(board));
			
			
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int r=0, o=0, b = 0;
		
		for (int i = 0; i < 1000000; i++) {
			int res = run(i % 2);
			
			if (res == 1)
				o++;
			else if (res == 2)
				r++;
			else
				b++;
			
			if(i % 10 == 0) {
				
				System.out.println(r + " - " + o + " - " + b);
				System.out.printf("%.2f%% - %.2f%% \n", 1.0*(r+b*0.5)/(o + r + b)*100, 1.0*(o + b*0.5)/(o + r + b)*100);
				
				
			}
			
		}
		System.out.println(r + " - " + o + " - " + b);

	}
	
	public static int [][][] Stringtoint(String [][] board){
		int [][][] arr = new int[4][4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = Ramiz.stringToArray(board[i][j]);
			}
		}
		
		return arr;
		
	}
	
	public static String [][] intToString(int [][][] board){
		String [][] arr = new String[4][4];
		String [] conv = new String[4];
		conv[0] = " BW";
		conv[1] = " TS";
		conv[2] = " SR";
		conv[3] = " SH";
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				if (board[i][j][0] == 0) {
					arr[i][j] = "E";
					continue;
				}
				arr[i][j] = "";
				
				for (int k = 0; k < 4; k++) {
					arr[i][j] += conv[k].charAt(board[i][j][k]); 
				}
			}
		}
		
		return arr;
		
	}

}
