package com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		
		System.out.println("Sorted" + sortList(Arrays.asList("Amit","Priya","Arun","Bittu")));
		System.out.println("Sorted" + sortList2(Arrays.asList("Amit","Priya","Arun","Bittu")));

	}

	private static List<String> sortList(List<String> asList) {
		
		asList.stream().sorted().collect(Collectors.toList());
		return asList.stream().sorted().collect(Collectors.toList());
	}
	
	private static List<String> sortList2(List<String> asList) {
		
		Collections.sort(asList);
		return asList;
	}
	
	

}
