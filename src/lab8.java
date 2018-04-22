import java.util.*;
public class lab8 {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
//		//indexOf, subString, charAt, toLowerCase, toUpperCase, 
//		
//		String sentence = "cmpe 150";
//		System.out.println(sentence);
//		
//		String input = console.nextLine();
//		System.out.println(input);
//		
//		String lower = input.toLowerCase();
//		int index1 = input.indexOf("J");
//		System.out.println(index1);
//		char c = 'a';
//		char modified = (char) (c + 1);
//		int m = modified;
//		String result = "deneme";
//		result = c + result;
//		System.out.println(result);
//		System.out.println(modified);
//		System.out.println(m);
		
//		System.out.println(Sezar("zzzz 150", 50));
		String sentence = console.nextLine();
		char m = console.nextLine().charAt(0);
		System.out.println(method(sentence, m));
		
	}
	public static String traverseString(String sentence) {
		String result = "";
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			c += 1;
			result += c;
		}
		return result;
	}
	public static String x(String sentence) {
		String result = "";
		for(int i = 0 ; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c == ' ') {
				result += 'x';
				
			}
			else {
				result += c;
			}
		}
		return result;
	}
	public static String Sezar(String sentence, int shift) {
		String result = "";
		shift = shift % 26;
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
				c += shift;
				if(c >= 'z') {
					c -= 26;
				
				}
				else if(c > 'Z' && c < 'a') {
					c -= 26;
				}
				
			}
			result += c;
		}
		return result;
		
	}
	public static String method(String sentence, char x) {
		String result = "";
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c != x) {
				result += c;
			}
		}
		return result;
	}

}

























