import java.util.Scanner;
public class OY2016400024 {

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in); // Scanner to take user's info
		
		System.out.println("\tWelcome to MARS Interviewing Systems\n");
		System.out.println("Can I learn your name?");
		
		String name = sc.nextLine(); // A string that takes user's name
		
		
		int age = age(sc, name); // An integer to call age method and take its value
		
		if(age == 1) { //An if statement to check whether satisfy age requirement or not
			
			
			System.out.println("Nice! You are old enough. Let's look at the other question.");
			System.out.println("Wait, where is the next question?");
			System.out.println("Hmm.");
		
			zamanYiyici(14);//Calling zamanYiyici method to kill time
		
			System.out.println("Oh! Here it is.");
			
			int valueSex = sex(sc); // An integer to call sex method and take its value
			
			if(valueSex == 1) { //An if statement to check whether satisfy sex requirement or not
				
				System.out.println("The next question is about the position you are applying");
				System.out.println("For which position are you applying?");
				System.out.println("I bet you're applying for Software Engineer");
			
				sc.nextLine(); // An empty scanning to deal with the scanner problem
				String position = sc.nextLine(); // A string to take for which position user is applying
				while(!position.equalsIgnoreCase("Software Engineer") && !position.equalsIgnoreCase("Accountant")
						&& !position.equalsIgnoreCase("Academic") && !position.equalsIgnoreCase("yes")) { 
					// A while statement to make sure that user's input is correct
					System.out.println("We need to hire only Software Engineer, Accountant, Academic, so choose one of them.");
					position = sc.nextLine(); //to take the position again
				}
				int value = 0; //An integer to take position methods value and to call them
			
				if (position.equalsIgnoreCase("Software Engineer") || position.equalsIgnoreCase("Yes")) {
					// An if statement to check whether user applying for Software Engineer or not
					
					value = softwareEngineer(sc, name);		//Calling softwareEngineer method and taking its value
					
					
					}		
					
				else if(position.equalsIgnoreCase("Accountant")) {
					// An if statement to check whether user applying for Accountant or not
					value = accountant(sc, name);	//Calling accountant method and taking its value	
					}
				
				else if(position.equalsIgnoreCase("Academic")) {
					// An if statement to check whether user applying for Academic or not
					value = academic(sc, name);		//Calling academic method and taking its value			
					
				}
				
				if(value == 1) { //An if statement to check whether user satisfies the requirements or not
				
				System.out.println("Congrulations " + name + "! You are the guy ;))");
				}
			}
			
		}
		
	}
	public static int age(Scanner sc, String name) { // A method to check whether user is at least 18 years old or not
		System.out.println("Hello " + name + ". How old are you?");
		
		int age = sc.nextInt(); // An integer to take user's age
		
		if(age < 18) {// An if statement to check whether user is at least 18 years old or not
			
			System.out.println("Sorry " + name + ". You should be at least 18 years old dude. :((");
			
			return 0;
		}
		
		return 1;
	}
	
	public static int sex(Scanner sc) { // A method about military service
		
		System.out.println("It is quite sexist question but are you a male?");
		
		String beingMale = sc.next(); // A string that takes user's sex
		
		while(!beingMale.equalsIgnoreCase("Yes") && !beingMale.equalsIgnoreCase("no")) { 
			// A while statement to make sure that user's input
			
			System.out.println("Please only say 'Yes' or 'No' ");
			
			beingMale = sc.next(); // to take sex again
		}
		if(beingMale.equalsIgnoreCase("Yes")) { 
			// An if statement to check having completed military service if the user is male
			
			System.out.println("Hmm. Then we have a little problem.");
			System.out.println("Have you completed your military service?");
		
			String militaryService = sc.next(); // A String that takes having completed military service
			
			while(!militaryService.equalsIgnoreCase("Yes") && !militaryService.equalsIgnoreCase("no")) { 
				// A while statement to make sure that user's input
				
				System.out.println("Please only say 'Yes' or 'No' ");
				
				militaryService = sc.next(); // to take having completed military service
			}
			
			if(militaryService.equalsIgnoreCase("Yes")) {
				// An if statement to check whether user have completed military service or not
				
				System.out.println("Perfect! There is not any problem.");
			
				return 1; //returning positive
			}
			
			else {
				
				System.out.println("Sorry. You should have done your military service for this job :((");
				
				return 0; //returning negative
			}
		}
		System.out.println("That means you don't have to complete any military service! Great!");
		
		return 1; // returning positive if the user is not male
	}
	public static int softwareEngineer(Scanner sc, String name) {
		// A method to check Software Engineer requirements
		
		System.out.println("Haha! I liked you dude!");
		System.out.println("There is some questions I have prepared for you.");
		System.out.println("Do you have a university degree?");
		
		String uniDegree = sc.next(); // A string that takes user have a university degree or not
		while(!uniDegree.equalsIgnoreCase("Yes") && !uniDegree.equalsIgnoreCase("no")) {
			// a while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			uniDegree = sc.next(); //to take having a university degree
		}
		
		if(uniDegree.equalsIgnoreCase("No")) { // An if statement to check user have a university degree or not
			
			System.out.println("Oh C'Mon. If you don't have even a university degree, there is nothing to do");
		
			return 0; //returning negative
		}
		System.out.println("Huh, thanks God!");
		System.out.println("Yesterday a man applied for this position but he doesn't have any university degree even!");
		System.out.println("Can you believe this man?");
		System.out.println("However");
		System.out.println("In which field?");
		
		sc.nextLine(); // An empty scanning to deal with the scanner problem
		String field = sc.nextLine(); // A string that takes in which field user have a university degree
		
		
		
		if(field.equalsIgnoreCase("computer engineering") || field.equalsIgnoreCase("computer science")
				|| field.equalsIgnoreCase("software engineering")) {
			// An if statement to check in which field user applying is correct
			if(field.equalsIgnoreCase("computer engineering") || field.equalsIgnoreCase("computer science")) {
				//An if statement to check user's experience as a software engineer
				System.out.println("I guess you have more than three years of experience as a software engineer");
				System.out.println("Right?");
				
				String ans = sc.next(); // A string that takes user's experience
				while(!ans.equalsIgnoreCase("Yes") && !ans.equalsIgnoreCase("no")) {
					// a while statement to make sure that user's input is correct
					System.out.println("Please only say 'Yes' or 'No' ");
					
					ans = sc.next(); //to take answer again
				}
				
				if(ans.equalsIgnoreCase("no")) { 
					// An if statement to check whether user satisfy requirement of experience or not
					
					System.out.println("Sorry Dude :(");
					
					return 0;//returning negative
				}
			}
			
			
			System.out.println("You are awesome!");
			System.out.println("I have questions about languages now.");
			System.out.println("Can you speak Turkish?");
			
			zamanYiyici(14);//Calling zamanYiyici method to kill time
			
			System.out.println("Just Kiddin'");
			System.out.println("Of course questions are about languages you know to program in");
			System.out.println("Do you know how to program in JAVA?");
			
			int languageCounter = 0; //An integer to count how many languages user know how to program in
			
			String ans1 = sc.next(); // A String that takes whether user know how to program in JAVA or not
			
			while(!ans1.equalsIgnoreCase("Yes") && !ans1.equalsIgnoreCase("no")) {
				// A while statement to make sure that user's input is correct
				System.out.println("Please only say 'Yes' or 'No' ");
				
				ans1 = sc.next();//to take user's answer again
			}
			
			if(ans1.equalsIgnoreCase("Yes")) {//An if statement to count languages
				
				System.out.println("Then you can write a program like this?");
				System.out.println("Haha, I like you more and more");
				
				languageCounter++; //increasing the counter
			}
			System.out.println("Do you know how to program in C?");
			
			String ans2 = sc.next(); // A String that takes whether user know how to program in C or not
			
			while(!ans2.equalsIgnoreCase("Yes") && !ans2.equalsIgnoreCase("no")) {
				// A while statement to make sure that user's input is correct
				System.out.println("Please only say 'Yes' or 'No' ");
				
				ans2 = sc.next();//to take user's answer again
			}
			
			if(ans2.equalsIgnoreCase("Yes")) {//An if statement to count languages
				
				System.out.println("Hmm.");
				
				languageCounter++;//increasing the counter
			}
			System.out.println("Do you know how to program in Prolog?");
			
			String ans3 = sc.next();// A String that takes whether user know how to program in Prolog or not
			
			while(!ans3.equalsIgnoreCase("Yes") && !ans3.equalsIgnoreCase("no")) {
				// A while statement to make sure that user's input is correct
				System.out.println("Please only say 'Yes' or 'No' ");
				
				ans3 = sc.next();//to take user's answer again
			}
			
			if(ans3.equalsIgnoreCase("Yes")) {//An if statement to count languages
				
				languageCounter++;//increasing the counter
			}
			
			else { // An else statement for talking only
				
				System.out.println("I heard this language first time too.");
				System.out.println("Nevermind");
			}
			
			
			if(languageCounter <= 1) { 
				// An if statement to check whether user satisfies language requirements or not
				System.out.println("Sorry dude. You have to learn more languages.");
				
				return 0;//returning negative
			}
			
			return 1; //returning positive
			
		}
		System.out.println("We are only looking for Computer Engineering, Computer Science, and Software Engineering. Sorry " + name + " :(");
		
		return 0; //returning negative if user is not applying in correct field
	}
	
	public static int accountant(Scanner sc, String name) { // A method to check Accountant requirements
		
		System.out.println("Let me use a more formal language.");
		System.out.println("Do you hold an accountanting degree?");
		
		String ans1 = sc.next(); // A string that takes user's holding an accountanting degree
		
		while(!ans1.equalsIgnoreCase("Yes") && !ans1.equalsIgnoreCase("no")) {
			//A while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans1 = sc.next(); // to take the answer again
		}
		
		if(ans1.equalsIgnoreCase("No")) { // An if statement to check whether user holds a degree or not
			
			System.out.println("Sorry " + name + ". You must hold an a accountanting degree.");
			
			return 0; //returning negative
		}
		
		System.out.println("Nice!");
		System.out.println("Do you know Excell well?");
		
		String ans2 = sc.next(); // A string that takes user's knowing Excell well
		
		while(!ans2.equalsIgnoreCase("Yes") && !ans2.equalsIgnoreCase("no")) {
			//A while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans2 = sc.next(); // to take the answer again
		}
		
		if(ans2.equalsIgnoreCase("No")) { // An if statement to check whether user knows Excell well or not
			
			System.out.println("Sorry " + name + ". You must know Excell well." );
			
			return 0; // returning negative
		}
		
		System.out.println("Hmm");
		System.out.println("Can you speak fluent English?");
		
		String ans3 = sc.next(); // A string that takes user's speaking fluent English
		
		while(!ans3.equalsIgnoreCase("Yes") && !ans3.equalsIgnoreCase("no")) {
			// A while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans3 = sc.next(); // to take the answer again
		}
		
		if(ans3.equalsIgnoreCase("No")) { // An if statement to check whether user speaks fluent English or not
			
			System.out.println("Do you have a friend who can translate for you?");
			
			String ans4 = sc.next();
			// A string that takes user have a friend who can translate for user or not 
			while(!ans4.equalsIgnoreCase("Yes") && !ans4.equalsIgnoreCase("no")) {
				// A while statement to make sure that user's input is correct
				System.out.println("Please only say 'Yes' or 'No' ");
				
				ans4 = sc.next(); // to take user's input again
			}
			
			if(ans4.equalsIgnoreCase("No")) {// An if statement to check whether user have a friend or not
				
				System.out.println("Don't you know Gültuð even?");
				System.out.println("However.");
				System.out.println("We will call you later.");
				System.out.println("Which means never.");
				
				return 0; //returning negative
			}
			System.out.println("Nice");
		}
		System.out.println("How many people do you know already working in this company.");
		System.out.println("You know");
		System.out.println("Oracle is the main thing for this job");
		
		int ans5 = sc.nextInt(); //The number of user's connection in this company
		
		while(ans5 < 0) { // A while statement to make sure that user's input is nonnegative
			System.out.println("Are you kiddin' me?");
			System.out.println("Answer this question again!");
			
			ans5 = sc.nextInt();//to take the input again
		}
		
		if(ans5 < 2) { // an if statement to check whether user's input satisfies the requirements or not
		
			System.out.println("It is not enough");
			System.out.println("Sorry " + name);
			
			return 0; //returning negative
		}
		
		System.out.println("Do you have a driving license?");
		
		String ans6 = sc.next(); // A string that takes user's having a driving license
		
		while(!ans6.equalsIgnoreCase("Yes") && !ans6.equalsIgnoreCase("no")) {
			//A while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans6 = sc.next(); // to take the answer again
		}
		
		if(ans6.equalsIgnoreCase("no")) {
			// An if statement to check whether user has a driving license or not
			System.out.println("Sorry " + name + ". You must have a driving license." );
			
			return 0; //returning positive
		}
		return 1; //if negative isn't returned, returns positive
		
	}
	public static int academic(Scanner sc, String name) {// A method to check Academic requirements
		
		System.out.println("Let me call you Sensei!");
		System.out.println("Do you speak English Sensei?");
		
		String ans1 = sc.next();// A string that takes user's speaking English
		
		while(!ans1.equalsIgnoreCase("Yes") && !ans1.equalsIgnoreCase("no")) {
			// A while statement to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans1 = sc.next(); // to take answer again
		}
		
		if(ans1.equalsIgnoreCase("no")) {// An if statement to check whether user knows English or not
			
			System.out.println("Are you kidding me?");
			System.out.println("How could you answer these questions?");
			System.out.println("Neyse bb");
			
			return 0; //returning negative
		}
		
		System.out.println("It's kinda weird question.");
		System.out.println("How many papers have you published hitherto?");
		
		int ans2 = sc.nextInt(); // Number of papers user has published hitherto
		
		while(ans2 < 0) {// A while statement to make sure that user's input is correct
			
			System.out.println("I think I heard you incorrectly");
			System.out.println("Could you answer again?");
			
			ans2 = sc.nextInt(); // to take the input again
		}
		
		if(ans2 < 3) { // An if statement to check whether number of papers are enough or not
			
			System.out.println("Sorry Sensei. That's not enough...");
			
			return 0; // returning negative
		}
		
		System.out.println("Wow, that's a nice number!");
		System.out.println("Do you love to teach?");
		
		String ans3 = sc.next(); // A string that takes user's loving to teach
		
		while(!ans3.equalsIgnoreCase("Yes") && !ans3.equalsIgnoreCase("no")) {
			//A while to make sure that user's input is correct
			System.out.println("Please only say 'Yes' or 'No' ");
			
			ans3 = sc.next(); // to take the input again
		}
		
		if(ans3.equalsIgnoreCase("no")) { // An if statement to check whether user loves to teach or not
			
			System.out.println("How type of sensei are you?");
			
			return 0; // returning negative
		}
		
		System.out.println("I love you too!");
		System.out.println("Öhm");
		System.out.println("Sorry");
		
		return 1; // returning positive
	}
	
	public static int zamanYiyici(int n) { //A method killing time
		
		int k = 1;
		
		for(int i = 1; i <= Math.pow(2, n) - 1; i++ ) { // a for statement to calculate something unnecessary
			
			k *= i;
			
			for(int j = 1; j <= Math.pow(2, n) - 1; j++) {
				
				k /= j;
			
			}
		}
		
		return k;
	}
}

































