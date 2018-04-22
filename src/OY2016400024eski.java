public class OY2016400024{
	public static void main(String [] args) {
		
		firstline();
		secondline();
		thirdline();
		fourthline();
		fifthline();
		sixthline();
		seventhline();
		stringline();
		
	}
	
	
	
	public static void BenimBiricikMethodum(String a, int b) { // a method to print the string "a" "b" times 
		for(int count = 1; count <= b; count++) {// Count is the number of the printed "a" strings
			System.out.print(a);
		}
	}
	public static void firstline () {  // A method printing the first line of the heads
		for(int count = 1; count <= 4; count++) { //Count is the number of the monkey heads
			
			BenimBiricikMethodum(" ", 6); //spaces before the heads
			
			BenimBiricikMethodum(".",1);
			BenimBiricikMethodum("-",1);
			BenimBiricikMethodum("\"",1);
			BenimBiricikMethodum("-",1);
			BenimBiricikMethodum(".",1);  //System.out.print(".-\"-.");
			
			BenimBiricikMethodum(" ", 6); //spaces after the heads
			
		}
		System.out.println();  // to move to next line
	}
	public static void secondline() { // A method printing the second line of the heads
		for(int count = 1; count <= 4; count++) { //Count is the number of the monkey heads
			BenimBiricikMethodum(" ", 4); //spaces before the heads
			//forehead of the monkeys
			BenimBiricikMethodum("_",1);
			BenimBiricikMethodum("/",1);
			BenimBiricikMethodum("_",1);
			BenimBiricikMethodum("-",1);
			BenimBiricikMethodum(".", 1);
			BenimBiricikMethodum("-", 1);
			BenimBiricikMethodum("_", 1);
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum("_", 1);	//Which is the similar to System.out.print("_/_-.-_\\_");
			BenimBiricikMethodum(" ", 4); //spaces after the heads
			
		}
		System.out.println(); //  to move to next line
	}
	public static void thirdline() {// A method printing the third line of the heads
		BenimBiricikMethodum(" ", 3); // spaces before the first monkey
		//eyes of the first monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("_", 2);
		BenimBiricikMethodum("}", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("{", 1);
		BenimBiricikMethodum("_", 2);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("\\", 1); 
		 //It is similar to System.out.print("/ __} {__ \\");
		BenimBiricikMethodum(" ", 6); // spaces between the first monkey and the second monkey
		// eyes of the second monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("|", 1); 
		BenimBiricikMethodum("(", 1);
		BenimBiricikMethodum(" o", 2); 
		BenimBiricikMethodum(" ", 1); 
		BenimBiricikMethodum(")", 1); 
		BenimBiricikMethodum("|", 1);
		BenimBiricikMethodum("\\", 1);  
		//It is similar to System.out.print("/|( o o )|\\"); 
		for(int count = 1; count <= 2; count++) {//Count is the number of spaces and eyes of the other monkeys
			
			BenimBiricikMethodum(" ", 6); // spaces before the other monkeys
			//eyes of the third and fourth monkey
			BenimBiricikMethodum("( ", 2);
			BenimBiricikMethodum("o", 1);
			BenimBiricikMethodum(" ", 1);
			BenimBiricikMethodum("o", 1);
			BenimBiricikMethodum(" )",2);  
			//It is similar to System.out.print("( ( o o ) )");
		}
		System.out.println();// to move to next line
	}
	public static void fourthline() {// A method printing the fourth line of the heads
		//Spaces before the first monkey
		BenimBiricikMethodum(" ", 2);
		// nose of the first monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("/", 2);
		BenimBiricikMethodum(" ", 2);
		BenimBiricikMethodum("\"", 1);
		BenimBiricikMethodum(" ", 2);
		BenimBiricikMethodum("\\", 2);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("\\", 1);
		//It is similar to System.out.print("/ //  \"  \\\\ \\"); 
		BenimBiricikMethodum(" ", 4);//Spaces between the first and the second monkey
		// nose of the second monkey
		BenimBiricikMethodum("|", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("/", 2);
		BenimBiricikMethodum(" ", 2);
		BenimBiricikMethodum("\"", 1);
		BenimBiricikMethodum(" ", 2);
		BenimBiricikMethodum("\\", 2);
		BenimBiricikMethodum(" ", 1); 
		BenimBiricikMethodum("|", 1);
		//It is similar to System.out.print("| //  \"  \\\\ |"); 
		BenimBiricikMethodum(" ", 6); // in order to use next for statement correctly
		
		for(int count = 1; count <= 2; count++) { //Count is the number of spaces and noses of the other monkeys
			// noses of the other monkeys
			BenimBiricikMethodum("|", 1);
			BenimBiricikMethodum("/", 1);
			BenimBiricikMethodum(" ", 2); 
			BenimBiricikMethodum("\"", 1);
			BenimBiricikMethodum(" ", 2);
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum("|", 1);
			//It is similar to System.out.print("|/  \"  \\|"); 
			BenimBiricikMethodum(" ", 8); // spaces between them
			
		}
		System.out.println();
	}
	public static void fifthline() {
		for(int count = 1; count <= 2; count ++) { //Count is the number of monkeys with the same mouth
			BenimBiricikMethodum(" ", count); // spaces between the first and the second monkey
			// mouth of the first and the second monkey
			BenimBiricikMethodum("/ ", 2);
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum("'", 1);
			BenimBiricikMethodum("-", 3);
			BenimBiricikMethodum("'", 1);
			BenimBiricikMethodum("/", 1);
			BenimBiricikMethodum(" \\", 2); 
			//It is similar to System.out.print("/ / \\'---'/ \\ \\");
		}
		
		BenimBiricikMethodum(" ", 6);// spaces before the third monkey
		// mouth of the third monkey
		BenimBiricikMethodum("\\", 1);
		BenimBiricikMethodum("'", 1);
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("^", 1);
		BenimBiricikMethodum("\\", 1);
		BenimBiricikMethodum("'", 1);
		BenimBiricikMethodum("/", 1);  
		//It is similar to System.out.print("\\'/^\\'/");
		BenimBiricikMethodum(" ", 10); // spaces before the fourth monkey
		// mouth of the fourth monkey
		BenimBiricikMethodum("\\", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum(".", 1);
		BenimBiricikMethodum("-", 1);
		BenimBiricikMethodum(".", 1);
		BenimBiricikMethodum(" ", 1); 
		BenimBiricikMethodum("/", 1);
		//It is similar to System.out.print("\\ .-. /");
		// to move to next line
		BenimBiricikMethodum("\n", 1);
		//It is similar to System.out.println();
	}
	public static void sixthline() {
		for(int count = 1; count <= 2; count ++) { //Count is the number of monkeys with the same chin
			BenimBiricikMethodum(" ", count); // spaces between the first and the second monkey
			// chin of the first and the second monkey
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum(" ", 1); 
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum("_", 1); 
			BenimBiricikMethodum("/", 1);
			BenimBiricikMethodum("`", 1);
			BenimBiricikMethodum("\"", 3);
			BenimBiricikMethodum("`", 1); 
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum("_", 1);
			BenimBiricikMethodum("/", 1); 
			BenimBiricikMethodum(" ", 1);
			BenimBiricikMethodum("/", 1);  
			//It is similar to System.out.print("\\ \\_/`\"\"\"`\\_/ /");
		}
		BenimBiricikMethodum(" ", 6); //spaces after the second monkey
		// chin of the third monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("`", 1);
		BenimBiricikMethodum("\\", 1);
		BenimBiricikMethodum(" ", 1);
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("`", 1);
		BenimBiricikMethodum("\\", 1); 
		//It is similar to System.out.print("/`\\ /`\\");
		BenimBiricikMethodum(" ", 10); // spaces after the third monkey
		// chin of the fourth monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("`", 1);
		BenimBiricikMethodum("\"", 3);
		BenimBiricikMethodum("`", 1);
		BenimBiricikMethodum("\\", 1);
		//It is similar to System.out.print("/`\"\"\"`\\");
		
		BenimBiricikMethodum("\n", 1);// to move to next line
		//It is similar to System.out.println();
	}
	public static void seventhline() {
		
		for(int count = 1; count <= 2; count ++) { //Count is the number of monkeys with the same bottom part
			
			BenimBiricikMethodum(" ", (2 * count)); // spaces between the first and the second monkey
			// bottom part of the first and the second monkey
			BenimBiricikMethodum("\\", 1);
			BenimBiricikMethodum(" ", 11); 
			BenimBiricikMethodum("/", 1);  
			//It is similar to System.out.print("\\           /"); 
		}
		
		BenimBiricikMethodum(" ", 6); //spaces after the second monkey
		// the bottom part of the third monkey
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum(" ", 2); 
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum("|", 1);
		BenimBiricikMethodum("\\", 1);
		BenimBiricikMethodum(" ", 2); 
		BenimBiricikMethodum("\\", 1); 
		//It is similar to System.out.print("/  /|\\  \\");
		BenimBiricikMethodum(" ", 8); // spaces after the third monkey
		// the bottom part of the last monkey and moving to the next line
		BenimBiricikMethodum("/", 1);
		BenimBiricikMethodum(" ", 7);
		BenimBiricikMethodum("\\", 1);
		//It is similar to System.out.println("/       \\");
		BenimBiricikMethodum("\n", 1); // to move one more line
		//It is similar to System.out.println();
	}
	public static void stringline() { //a method to print the last line
		System.out.println("-={ see no evil }={ hear no evil }={speak no evil }={ have no fun }=-");
	}
	
	
}

/*        .-"-.            .-"-.            .-"-.           .-"-.
        _/_-.-_\_        _/.-.-.\_        _/.-.-.\_       _/.-.-.\_
       / __} {__ \      /|( o o )|\      ( ( o o ) )     ( ( o o ) )
      / //  "  \\ \    | //  "  \\ |      |/  "  \|       |/  "  \|
     / / \'---'/ \ \  / / \'---'/ \ \      \'/^\'/         \ .-. /
     \ \_/`"""`\_/ /  \ \_/`"""`\_/ /      /`\ /`\         /`"""`\
      \           /    \           /      /  /|\  \       /       \

    -={ see no evil }={ hear no evil }={ speak no evil }={ have no fun }=-

*/