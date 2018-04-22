import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class quiz11 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		File input = new File("input.txt");
		
		String [][] board = piroje.scanFile(input);
		
		piroje.print(board);
		
		if(piroje.winCheck(board)) System.out.println("Ömerinki doru");
		else System.out.println("yalann");
		
		if(check(board)) System.out.println("bu da doru");
		else System.out.println("kolpaa");


	}
	public static boolean check(String[][]array) {
		char[] checklist =new char[4];
		checklist[0] = 'W';
		checklist[1] = 'S';
		checklist[2] = 'R';
		checklist[3] = 'S';
		char[] checklist2 =new char[4];
		checklist2[0] = 'B';
		checklist2[1] = 'T';
		checklist2[2] = 'S';
		checklist2[3] = 'H';
		
		
		int count = 0;
		int count2 = 0;
		for(int z = 0; z<4;z++) {//3b
			count2=0;
			for(int i = 0 ; i<4;i++) {//1b
		if(array[i][i].length()!=1) {//2
			
			
			if( array[i][i].charAt(z)==checklist[z]) {//a
				count2++;
			}//a
			if(array[i][i].charAt(z)==checklist2[z]) {//b
				count2--;
			}//b
		
		
	}//2
	if(count2 == -4 || count2 == 4) {return true;}
			}
		}
		

		for(int i = 0 ; i<4;i++) {//1
			for(int z = 0; z<4;z++) {//3
			count = 0;
			for(int j = 0;j<4;j++) {
				if(array[i][j].length()!=1) {
			
				
					if( array[i][j].charAt(z)==checklist[z]) {
						count++;
					}
					if( array[i][j].charAt(z)==checklist2[z]) {
						count--;
					}
					if(count==4||count==-4) {return true;}
				}
				
			}
			
		}//3
		}//1
		
		for(int j= 0;j<4;j++) {//a1
			for(int z = 0;z<4;z++) {//a4
			int count3=0;
			for(int i = 0;i<4;i++) {//a2
				if(array[i][j].length()!=1) {//a3
					
					if(array[i][j].charAt(z)==checklist[z]) {//b
						count3++;
					}//b
					if(array[i][j].charAt(z)==checklist2[z]) {//c
						count3--;
					}//c
					if(count3==-4||count3==4) {return true;}
					
				}//a3
				
			}//a2
			
		}//a4
		}//a1
		
	
return false;
	}

}
