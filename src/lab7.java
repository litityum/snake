import java.util.*;
public class lab7 {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter two numbers");
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println("Greatest common divisor of " + n1 + " and " + n2 + " is " + gcd(n1, n2));
		}
		
	}
	public static int isPrime(int n) {
		int a = 0;
		
		for(int i = 2; i <= n - 1; i++) {
			if(n % i == 0)
				a++;
		}
		
		if(a >= 1)
			return 0;
		
		return 1;
	}
	public static String twinPrime(int n, int k) {
		if(Math.abs(n - k) != 2)
			return "Bunlar ikiz deðil bi kere bebeðim";
		else if(isPrime(n) == 1 && isPrime(k) == 1)
			return "Bunlar ikiz asallar tatlým";
		return "En az ikisinden biri asal deðil bunlarýn maalesef :(";
	}
	public static void asallar(int x, int y) {
		if(x <= y) {
			for(int i = x; i <= y; i++) {
				if(isPrime(i) == 1) {
					System.out.print(i + " ");
				}
			}
			
		}
		else {
			for(int i = y; i <= x; i++) {
				if(isPrime(i) == 1) {
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public static int sumOfFactors(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0)
				sum += i;
		}
		return sum;
		}
	
	public static int gcd(int n, int m) {
		int a = 1;
		n = Math.abs(n);
		m = Math.abs(m);
		for(int i = 1; i <= Math.min(n, m); i++) {
			if(n % i == 0 && m % i == 0) {
				if(i > a)
					a = i;
			}
			
		}
		return a;
	}
	
}
