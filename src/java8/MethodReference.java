package java8;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("d", "b", "c", "a");
		// list.sort((a, b)->a.compareToIgnoreCase(b));
		
		list.sort(String::compareToIgnoreCase);
		System.out.println(list);

	}

}
