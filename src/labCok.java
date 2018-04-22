import java.util.*;
public class labCok {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if(checkColumnSum(arr)) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				sum += arr[i][0];
				
			}
			System.out.println(sum);
		}
		else {
			System.out.println("Not Equal");
		}
		

	}
	
	public static boolean checkColumnSum(int arr[][]) {
		
		int []res = new int [arr.length];
		
		for(int j = 0; j < arr.length; j++) {
			for(int i = 0; i < arr.length; i++) {
				res[j] += arr[i][j];
			}
		}
		for(int i = 0; i < arr.length - 1; i++) {
			if(res[i] != res[i + 1]) return false;
		}
		return true;
	}
	
	

}
