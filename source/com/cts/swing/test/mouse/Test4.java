package com.cts.swing.test.mouse;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test4 {

	public static void main(String...strings) {
	Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");
	
	Predicate<String> p1 = Predicate.isEqual("Two");
	Predicate<String> p2 = Predicate.isEqual("Three");
	
	Predicate<String> p3 = s -> s.length() > 3;
	
	stream.filter(p1.or(p2).and(p3)).forEach(System.out::println);
	
	
	}	
}
