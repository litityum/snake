public class quiz5{
	public static void main(String [] args) {
		System.out.printf("%.2f" ,myfunc(5,3));;
	}
	public static double power(double x, int a) {
		int result = 1;
		for(int i = 1; i <= a; i++) {
			result *= x;
		}
		return result;
	}
	public static double squareRoot(double x) {
		return Math.sqrt(x);
	}
	public static double myfunc(double x, int a) {
		return power(x,a) - squareRoot(x);
	}
}