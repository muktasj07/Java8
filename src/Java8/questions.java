package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class questions {
	public static void main(String[] args) {

		String input = "JavaTechieJavaTechielo";

		// find the occurance
		// String[] result = input.split("");
		// System.out.println(result);

		Map<String, Long> map = Arrays.stream(input.split("")).collect(Collectors.groupingBy(/* s -> s */
				Function.identity(), Collectors.counting()));
		System.out.println(map);

		// find duplicate
		List<String> duplicate = Arrays.stream(input.split("")).collect(Collectors.groupingBy(/* s -> s */
				Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> x.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(duplicate);

		// find unique
		List<String> unique = Arrays.stream(input.split("")).collect(Collectors.groupingBy(/* s -> s */
				Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> x.getValue() == 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(unique);

		// find first non repeating element from a string
		String firstnonrepeatelement = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(/* s -> s */ Function.identity(), LinkedHashMap::new,
						Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
		System.out.println(firstnonrepeatelement);

		// find second highest number from given array
		int[] numbers = { 5, 9, 11, 2, 21, 1 };
		Integer integer = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(integer);

		// find longest string from an given array
		String[] strArray = { "java", "springboot", "microservices" };
		String longestString = Arrays.stream(strArray)
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
		System.out.println(longestString);

		// find all elements from array who starts with 1

		List<String> StringList = Arrays.stream(numbers).boxed().map(s -> s + "").filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(StringList);

//----------------------------------------------------------------------------------------------------------------

//Sort all the values in its descending order
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		List<Integer> collect = myList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect);

		
		
		
		
		
		// Given an integer arrays nums, return true if any value appears at least twice
		// in the array
		// return false if every element is distinct
		int[] numbers1 = { 5, 9, 11, 2, 21, 1 };
		List<Integer> list = Arrays.stream(numbers1).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(list);
		if (set.size() == list.size()) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}

		// concatenate two streams

		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");

		Stream<String> concateStream = Stream.concat(list1.stream(), list2.stream());
		// concatented the list1 and list2 by converting them into stream

		concateStream.forEach(str -> System.out.print(str + " "));

		System.out.println();

		
		
		
		
		// cube on list elements and filter numbers greater than 50
		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		List<Integer> collect2 = integerList.stream().map(i -> i * i * i).filter(i -> i > 50)
				.collect(Collectors.toList());
		System.out.println(collect2);

		
		
		
		
		String str = "ABBA";
		//Arrays.stream(str.split("")).sorted(Collections.reverseOrder()).forEach(System.out::print);
		
	}
}
