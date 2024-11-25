import java.util.Random;

//
//** Functions for checking if a given string is an anagram. */
public class Anagram { 
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		//Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		//String new_str = "";\
		//String new_str1 ="";
		boolean bool = false;
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		char [] arr = new char[str1.length()];
		for (int k = 0; k < str1.length(); k ++){
			arr[k] = str1.charAt(k);
		}
		for(int i = 0; i< str1.length(); i++){
			//go throw the first string
			for(int j = 0; j < str2.length(); j++){
				if (str1.charAt(i) == str2.charAt(j)){
					for (int s = 0; s < arr.length; s ++){
						if (arr[s] == str1.charAt(i)) {
							arr [s] = (char)'-';
						}
					}
				}

			}
		}
		for(int t = 0; t < arr.length; t++){
			if (arr[t] != '-') {
				bool = false;
				break;
			}else {bool = true;}
		}	
		return bool;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String new_str = "";
		char lower_char;
		for(int i = 0; i < str.length(); i++){
			if ((str.charAt(i) >= 97 && str.charAt(i) <= 122) || str.charAt(i) == 32)  {
				new_str = new_str + str.charAt(i);
			}
			else{
				if ((str.charAt(i) >= 65 && str.charAt(i) <= 90)|| str.charAt(i) == 32){
					lower_char = (char)(str.charAt(i) + 32);
					new_str = new_str + lower_char;
				}
			}
		}
		return new_str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		return "0";
	}
}

