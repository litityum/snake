import java.util.*;
import java.io.*;
public class lab12 {

	public static void main(String[] args) throws FileNotFoundException{

		
		
		PrintStream stream = new PrintStream("modified.txt");
		
		Random rand = new Random();
		
		Scanner console = new Scanner(System.in);
		
		int N = console.nextInt();
		int[][] matrix = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				matrix[i][j] = rand.nextInt(32) + 1;
			}
		}
		
		int M = console.nextInt();
		
		int [][] transpose = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(matrix[i][j] >= M)
				transpose[i][j] = 1;
			}
		}
		
		printMatrix(matrix, stream);
		stream.println();
		printMatrix(transpose, stream);
		
		stream.close();
	}
	
	public static void printMatrix(int [][] matrix, PrintStream stream) {
		
				
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				stream.print(matrix[i][j] + " ");
			}
			stream.println();
		}
		
	}
	

	public static boolean contains(int [] matrix, int n) {
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i] == n) return true;
		}
		
		return false;
	}

	public static int occuring(int matrix []) {
		int [] occur = new int[matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(matrix [i] == matrix[j]) occur[i]++;
			}
			
		}
		
		int max = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			if(occur[i] > max) max = occur[i];
		}
		
		for(int i = 0; i < matrix.length; i++) {
			if(max == occur[i]) return matrix[i];
		}
		
		return 0;
		
	}

}
