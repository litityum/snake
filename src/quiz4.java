public class quiz4{
	public static void main(String [] args) {
		approximatePi(1000000000);
	}
	public static void approximatePi(int K) {
		double result = 1;
		for(int n = 1; ; n++) {
		
			double a= 4.0 * n * n;
			result *= ((a) / (a - 1));
			
			if(n % 100000000 == 0) {
				System.out.println(2 * result);
				System.out.println(Math.PI);
			}
			
		
		}
		
		
	}
}