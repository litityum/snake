public class lab3{
	public static void main(String [] args) {
		faktoriyel();
	}
	public static void rental() {
		System.out.println("Each person should pay");
		System.out.println("H.Üstü:\t" + 1800/3.0);
		System.out.println("Þiþli:\t" + 1700/3.0);
		System.out.println("Levent:\t" + 1400/3.0);
		System.out.println("Avg:\t" + 4900/9.0);
	}
	public static void expenses() {
		double total = 215;
		double books = total / 5;
		double akbil = total / 3;
		double left = total - books - akbil;
		
		
		System.out.println("Özlem's expenses");
		System.out.println("Books:\t" + books);
		System.out.println("Akbil:\t" + akbil);
		System.out.println("Left:\t" + left);
		System.out.println("Total:\t" + (books + akbil));
	}
	public static void gpa() {
		double cmpe150 = 3 * 3.50;
		double math101 = 4 * 3.00;
		double phys121 = 4 * 3.00;
		double ec101 = 3 * 4.00;
		double chem105 = 4 * 2.50;
		System.out.println("GPA of the student is " + (cmpe150 + math101 + phys121 + ec101 + chem105) / 18);
	}
	public static void faktoriyel() {
		int j = 1;
		for (int i = 1; i < 6; i++) {
			j *= i;
		}
		System.out.println(j);
	}
}