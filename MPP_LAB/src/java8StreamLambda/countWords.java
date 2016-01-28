package java8StreamLambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class countWords {
	
	public static void main(String args[]){
		String[] words = {"Mikiyas","Jospeh","Dawit","Tinbit","Friat","Eyob","Victor",
				"Gunajam","kibrom","Hagod","Loretta","chlada","casablanka"};
		
		List<String> list_of_words = Arrays.asList(words);
		
		System.out.println("All list of names " );
		list_of_words.forEach(System.out::println);
		
		countWords(list_of_words, "c", "d", 4);		
		
	}

	private static int countWords(List<String> list_of_words, String string1, String string2, int len) {
		Predicate<String> strOfGiveLen = str->(str.length() >= len);
		Predicate<String> containsCbutNotD = str->((str.contains(string1) || str.contains(string1.toUpperCase())) 
													&& 
													((!str.contains(string2) && !str.contains(string2.toUpperCase()))));
		
		int num_of_words = (int)list_of_words.stream()
				.filter(strOfGiveLen)
				.filter(containsCbutNotD)
				.count();
		System.out.println("Names of length 4 and contains c but not d, total found  = " + num_of_words);
		
		list_of_words.stream()
		.filter(strOfGiveLen)
		.filter(containsCbutNotD)
		.forEach(System.out::println);
		
		return num_of_words;
		
	}

}
