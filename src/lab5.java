public class lab5{
	public static void main(String [] args) {
		int number1 = 1;
		double number2 = 3.14;
		System.out.printf("The value of the number is %d", number1);
		System.out.println();
		System.out.printf("%f \n", number2);
		String sa = "Selam";
		System.out.printf("%.3s", sa);
		System.out.println();
		
		System.out.println(squareArea(12));
		System.out.println(circleArea(12 / Math.sqrt(Math.PI)));
		
		System.out.printf("%.3f \n", cyclinderArea(7.136495 , 5.0));
		
		System.out.println(factorial(3));
		System.out.println(P(5,3));
		System.out.println(C(6,3));
		
	}
	public static double Average(int a, int b) {
		
		return (a + b) / 2.0;
	} 
	
	public static double squareArea(double a) {
		return a * a;
	}
	public static double circleArea(double r) {
		return Math.PI * r * r;
	}
	public static double cyclinderArea(double r, double h) {
		double cArea = circleArea(r);
		double volume = cArea * h;
		return volume;
	}
	public static int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	public static int P(int n, int k) {
		int result = factorial(n)/factorial(n-k);
		return result;
	}
	public static int C(int n, int k) {
		int result = P(n,k)/factorial(k);
		return result;
	}
}