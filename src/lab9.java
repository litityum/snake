import java.util.*;
public class lab9 {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int sum = 0;
		int roll;
		System.out.println("Enter quit to exit, roll to roll the dice");
		String input = sc.next();
		while(!input.equalsIgnoreCase("quit")) {
			roll = rand.nextInt(6) + 1;
			if(roll != 6)
			sum += roll;
			else sum = 0;
			System.out.println("Result of the dice " + roll );
			System.out.println("Your current score is " + sum);
			System.out.println("Enter quit to exit, roll to roll the dice");
			input = sc.next();
		}
		System.out.println("Your score is " + sum);
		
	}
	
	
	public static boolean isPalindrome(String s) {
		
		for(int i = 1; i < s.length(); i++) {
			
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
		
		}
		
		return true;
	}
	
	

}
