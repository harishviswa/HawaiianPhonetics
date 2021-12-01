import java.util.ArrayList;
import java.util.Scanner; //Scanner import
//colloborated with anwith and anshul in class
//https://www.w3schools.com/java/java_arraylist.asp
//above link is what I used for reference for String arraylist to jog my memory
//check edge cases - done 3/3


public class HawaiianPhonetics {

	//fields
	public static boolean isValid = true;
	public static boolean isAgain = true;
	public static int invalidCounter = 0;

//validate password method
	public static boolean validateWord(String word) {

		// need to add for spaces and apostrophes
		String invalidC = "";
		char[] HawaiianCharacters = { 'p', 'k', 'h', 'l', 'm', 'n', 'a', 'e', 'i', 'o', 'u', 'w', ' ', '\'' };
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			boolean found = false;
			for (int j = 0; j < HawaiianCharacters.length; j++) {
				if (HawaiianCharacters[j] == c) { // rework, if c is found to be equal to something in the array set
													// found to true
					found = true;
				}
			}
			// check found, if its still false you know c is invalid
			if (!found) {
				// String invalidCharacters += Character.toString(c);
				invalidC += c;
				isValid = false;
				invalidCounter++;
			}
		}
		if (invalidCounter > 0) {
			System.out.println("The invalid characters are: " + invalidC);
		} else {
			isValid = true;
			System.out.println(isValid);
		}
		return isValid;
	}
//ArrayList method and implementation

	public static ArrayList<String> add(String word, ArrayList<String> phoneticGenerator) {
		//converting word to lowercase to be processed
		word = word.toLowerCase();
		if (word.length() <= 1) {
			if (word.equals("")) {
				return phoneticGenerator;
			//else if statements to add phonetics for regular characters
			} else if (word.charAt(0) == 'p') {
				phoneticGenerator.add("p ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'k') {
				phoneticGenerator.add("k ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'h') {
				phoneticGenerator.add("h ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'l') {
				phoneticGenerator.add("l ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'm') {
				phoneticGenerator.add("m ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'n') {
				phoneticGenerator.add("n ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'a') {
				phoneticGenerator.add("ah ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'e') {
				phoneticGenerator.add("eh ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'i') {
				phoneticGenerator.add("ee ");
				return phoneticGenerator;
			} else if (word.charAt(0) == 'o') {
				phoneticGenerator.add("oh ");
				return phoneticGenerator;
			}  else if (word.charAt(0) == 'u') {
				phoneticGenerator.add("oo ");
				return phoneticGenerator;
			}else if (word.charAt(0) == 'w') {
					phoneticGenerator.add("w ");
					return phoneticGenerator;
			}else if(word.charAt(0) == '/') {
				phoneticGenerator.add("' ");
				return phoneticGenerator;
			} else {
				return phoneticGenerator;
			}
		//using substring to code for vowel groups
		//substring easier to process than adding to a string
		//using +=
		//.charAt(i+1) was not working
		//substring?
		} else {
			if (word.charAt(0) == 'p') {
				phoneticGenerator.add("p");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'k') {
				phoneticGenerator.add("k");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'h') {
				phoneticGenerator.add("h");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'l') {
				phoneticGenerator.add("l");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'm') {
				phoneticGenerator.add("m");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'n') {
				phoneticGenerator.add("n");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'w') {
				phoneticGenerator.add("w");
				add(word.substring(1), phoneticGenerator);
			} else if (word.charAt(0) == 'a') {
			//for specific vowel combos involving a 
			//w included
				if (word.charAt(1) == 'i' || word.charAt(1) == 'e') {
					phoneticGenerator.add("eye-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'o' || word.charAt(1) == 'u') {
					phoneticGenerator.add("ow-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'w') {
					phoneticGenerator.add("aw");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == '\''){
					phoneticGenerator.add("ah-");
					add(word.substring(2), phoneticGenerator);
				} else {
					phoneticGenerator.add("ah-");
					add(word.substring(1), phoneticGenerator);
				} 
			} else if (word.charAt(0) == 'e') {
			//vowel combos involving e
			//w included
				if (word.charAt(1) == 'i') {
					phoneticGenerator.add("ay-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'u') {
					phoneticGenerator.add("eh-oo-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'w') {
					phoneticGenerator.add("eh-v");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == '\''){
					phoneticGenerator.add("eh-");
					add(word.substring(2), phoneticGenerator);
				} else {
					phoneticGenerator.add("eh-");
					add(word.substring(1), phoneticGenerator);
				}
			} else if (word.charAt(0) == 'i') {
			//vowel combos involving i
			//w included
				if (word.charAt(1) == 'u') {
					phoneticGenerator.add("ew-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'w') {
					phoneticGenerator.add("ee-v");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == '\''){
					phoneticGenerator.add("ee-");
					add(word.substring(2), phoneticGenerator);
				} else {
					phoneticGenerator.add("ee-");
					add(word.substring(1), phoneticGenerator);
				}
			} else if (word.charAt(0) == 'o') {
			//vowel combos involving o
			//w included
				if (word.charAt(1) == 'i') {
					phoneticGenerator.add("oy-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'u') {
					phoneticGenerator.add("ow-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'w') {
					phoneticGenerator.add("oh-w");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == '\''){
					phoneticGenerator.add("oh-");
					add(word.substring(2), phoneticGenerator);
				} else {
					phoneticGenerator.add("oh-");
					add(word.substring(1), phoneticGenerator);
				}
			} else if (word.charAt(0) == 'u') {
			//vowel combos involving u
			//w included
				if (word.charAt(1) == 'i') {
					phoneticGenerator.add("ooey-");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == 'w') {
					phoneticGenerator.add("oo-w");
					add(word.substring(2), phoneticGenerator);
				} else if (word.charAt(1) == '\''){
					phoneticGenerator.add("oo-");
					add(word.substring(2), phoneticGenerator);
				} else {
					phoneticGenerator.add("oo-");
					add(word.substring(1), phoneticGenerator);
				}
			} else {
			//returning phonetic pronunciation
				return phoneticGenerator;
			}
		}
		return phoneticGenerator;

	}

//generatePhonetics method
	public static String generatePhonetics(String word) {
		String Phonetic = "";
		ArrayList<String> phoneticGenerator = new ArrayList<String>();
		ArrayList<String> phoneticElements = add(word, phoneticGenerator);
		for (int i = 0; i < phoneticElements.size(); i++) {
			Phonetic = Phonetic + phoneticElements.get(i);
		}
		//capitalizes first letter
		Phonetic = Phonetic.substring(0, 1).toUpperCase() + Phonetic.substring(1);
		//makes sure there are no hyphens at the end
		if(Phonetic.charAt(Phonetic.length() - 1) == '-') {
			Phonetic = Phonetic.substring(0, Phonetic.length() - 1);
		}
		return Phonetic;

	}
//continue until sentinel value is entered method

	public static boolean askAgain(String redo) {
		//in case the user inputs lower case value
		redo = redo.toUpperCase();
		if(redo.equals("Y")) {
			isAgain = true;
		}
		if(redo.equals("N")) {
			isAgain = false;
			System.out.println("End of program.");
		}
		
		return isAgain;
		
	}

//Main method

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a Hawaiian Word: ");
		String input = s.nextLine();
		System.out.println(validateWord(input));
		// enter a for loop to ask the user to enter valid word if invalid word is
		// entered
		Scanner s2 = new Scanner(System.in);
		while (invalidCounter > 0) {
			System.out.println("Please enter a Hawaiian Word: ");
			String input2 = s2.nextLine();
			input = input2;
			invalidCounter = 0;
			validateWord(input2);
		}
		if (isValid) {
			System.out.println(generatePhonetics(input));
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to enter another word? Enter Y for Yes and N for No.");
		String redo = scan.nextLine();
		askAgain(redo);
		while(askAgain(redo)) {
			Scanner s1 = new Scanner(System.in);
			System.out.println("Please enter a Hawaiian Word: ");
			String input1 = s1.nextLine();
			System.out.println(validateWord(input1));
			// enter a for loop to ask the user to enter valid word if invalid word is
			// entered
			Scanner s21 = new Scanner(System.in);
			while (invalidCounter > 0) {
				System.out.println("Please enter a Hawaiian Word: ");
				String input2 = s21.nextLine();
				input1 = input2;
				invalidCounter = 0;
				validateWord(input2);
			}
			if (isValid) {
				System.out.println(generatePhonetics(input1));
			}
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Would you like to enter another word? Enter Y for Yes and N for No.");
			String redo1 = scan1.nextLine();
			redo = redo1;
			askAgain(redo1);
		}
		
		

	}
}