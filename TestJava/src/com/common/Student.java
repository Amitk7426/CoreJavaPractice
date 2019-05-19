package com.common;

import java.util.ArrayList;

public class Student {

	String name;
	String age;
	String city;
	
	String semister;
	
	public Student(String name, String age, String city, String semister) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.semister = semister;
	}
	public String getSemister() {
		return semister;
	}
	public void setSemister(String semister) {
		this.semister = semister;
	}
	public Student(String name, String age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	public static ArrayList<Student> getStudentList() {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("Amit", "22", "Delhi"));
		stuList.add(new Student("Amit", "21", "Pune"));
		stuList.add(new Student("Aashish", "56", "Delhi"));
		stuList.add(new Student("Arun", "29", "Delhi"));
		stuList.add(new Student("Aashish", "24", "Nagpur"));
		stuList.add(new Student("Arun", "30", "Mumbai"));
		return stuList;
	}
	
	public static ArrayList<Student> getStudentList2() {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("Amit", "22", "Delhi", "4"));
		stuList.add(new Student("Amit", "21", "Pune", "2"));
		stuList.add(new Student("Aashish", "56", "Delhi", "4"));
		stuList.add(new Student("Arun", "29", "Delhi", "2"));
		stuList.add(new Student("Aashish", "24", "Nagpur", "5"));
		stuList.add(new Student("Arun", "30", "Mumbai", "5"));
		return stuList;
	}
	
	
}
