
import java.util.*;
public class lab11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int k = Math.min(n, m);
		int count = 0;
		
		int [] arr1 = new int[n];
		int [] arr2 = new int[m];
		int [] arr3 = new int[k];
		for(int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr1[i] == arr2[j]) {
					arr3[count] = arr1[i];
					count++;
				}
			}
			
		}
		for(int i = 0; i < k ; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		
	}
	
	public static int asal(int N) {
		int [] asal = new int[N];
		
		
		if(N == 1) {
			asal[1] = 2;
			return 2;
		}		
		
		else {
			for(int i = asal(N - 1) + 1; true; i++) {
				for(int j = 1; j < N; j++) {
					if(i % asal(j) == 0) {
						break;
					}
					else if(j == N - 1){
						asal[N] = i;
						return i;
					
						
					}
				}
				
			}
		}
		
	}

}
