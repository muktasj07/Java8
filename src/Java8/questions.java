package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class questions {
	public static void main(String[] args) {

		String input = "JavaTechieJavaTechielo";

		// find the occurance
		// String[] result = input.split("");
		// System.out.println(result);
		Map<String, Long> map = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(/* s -> s */ Function.identity(), Collectors.counting()));
		System.out.println(map);

		// find duplicate
		List<String> duplicate = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(/* s -> s */ Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(duplicate);

		// find unique
		List<String> unique = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(/* s -> s */ Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(unique);
		
		//find first non repeating element from a string
	  String firstnonrepeatelement = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(/* s -> s */ Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream()
				.filter(x -> x.getValue()==1)
				.findFirst().get().getKey();
	  System.out.println(firstnonrepeatelement);
	  
	  //find second highest number from given array
	  int[] numbers = {5,9,11,2,21,1};
	  Integer integer = Arrays.stream(numbers).boxed()
	  .sorted(Comparator.reverseOrder())
	  .skip(1)
	  .findFirst()
	  .get();
	  System.out.println(integer);
	  
	  
	  //find longest string from an given array
	  String[] strArray = {"java", "springboot","microservices"};
	  String longestString = Arrays.stream(strArray)
			  .reduce((word1,word2) ->word1.length()>word2.length() ? word1:word2)
	          .get();
	  System.out.println(longestString);
	  
	  //find all elements from array who starts with 1
	  
	  List<String> StringList = Arrays.stream(numbers).boxed()
			  .map( s -> s + "")
			  .filter(s->s.startsWith("1"))
			  .collect(Collectors.toList());
	  System.out.println(StringList);
		
	}
}
