package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
	public static void main(String args[]) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		// Filter
		List<Dish> vegeterianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		System.out.println(vegeterianMenu);
		
		// distinct
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(n -> n % 2 == 0).distinct().forEach(System.out::println);
		
		// limit
		List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
		System.out.println(dishes);
		
		// skip
		dishes = menu.stream().filter(d -> d.getCalories() > 300).skip(2).limit(3).collect(Collectors.toList());	
		System.out.println(dishes);
		
		// map
		List<String> dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());
		System.out.println(dishNames);
		List<Integer> wordLengths = menu.stream().map(d -> d.getName().length()).collect(Collectors.toList());
		System.out.println(wordLengths);
		
		// flatmap
		String[] wordsArr = {"hello world", "hi"};
		List<String> words = Arrays.asList(wordsArr);
		List<String> uniqueChars = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		System.out.println(uniqueChars);
		
		// Quiz 5.2
		List<Integer> nums = Arrays.asList(1,2,3,4,5);
		List<Integer> squares = nums.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squares);
		
		// findAny
		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
	}
}
