public class lab4 {
	public static final double PI = 3.14;
	
	
	public static void main ( String [] args) {
		drawParallel(4);
	}
	public static void CircleArea (int r) {
		System.out.println(PI*r*r);
	}
	public static void factorial(int n) {
		int result = 1;
		for(int i = 1; i<= n ; i++) {
			result *= i;
		}
		System.out.println(result);
	}
	public static void distance (int x1, int y1, int x2, int y2) {
		System.out.println(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}
	public static void drawParallel(int N) {
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N - i; j++) {
			
				System.out.print("a");
			
			}
			
			for(int j = 1; j <= N; j++) {
			
				System.out.print("*");
			
			}
			
			for(int j = 1; j <= i - 1; j++) {
				System.out.print("a");
			}
			System.out.println();
		}
		
	}
}