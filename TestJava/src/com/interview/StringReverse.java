package com.interview;

public class StringReverse {

	public static void main(String[] args) {
		
		System.out.println("Reverse:"+reverseStr("Amit Priya"));

	}

	private static String reverseStr(String string) {
		String [] strArray = string.split(" ");
		
		StringBuilder strBuild = new StringBuilder();
		for (String str : strArray) {
			strBuild.append(reverse(str) + " ");
		}
		return strBuild.toString();
	}

	private static String reverse(String str) {
		if(str.length() == 1)
			return str;
		else
			return reverse(str.substring(1)) + str.charAt(0);
	}

}
