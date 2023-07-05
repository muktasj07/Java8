package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class find_same_elements_from_twoarrays {

	public static void main(String[] args) {
	
		int[] array1= {1,2,3,4,5};
		int[] array2= {4,5,6,7,8};
		
		fetchCommonElements(array1, array2);

	}

	private static void fetchCommonElements(int[] array1, int[] array2) {
		
		List<Integer> list = Arrays.stream(array1).filter(number -> Arrays.stream(array2).anyMatch(arr2 -> arr2==number)).boxed().collect(Collectors.toList());
		System.out.println(list);
	}

}
