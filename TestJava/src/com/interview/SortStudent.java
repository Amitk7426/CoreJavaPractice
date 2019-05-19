package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.common.Student;

public class SortStudent {

	public static void main(String[] args) {

		System.out.println("Sort Student" + sortCollection(Student.getStudentList()));
		System.out.println("Sort Student" + sortStream(Student.getStudentList()));
		System.out.println("Sort Student" + sortStream2(Student.getStudentList()));
	
		System.out.println("Sort Student" + getStudentMap(Student.getStudentList2()));
		System.out.println("Sort Student" + sortMapStream(getStudentMap(Student.getStudentList2())));
		System.out.println("Sort Student" + sortMapStreamValues(getStudentMap(Student.getStudentList2())));

		System.out.println("Sort Student" + sortMap(getStudentMap(Student.getStudentList2())));
		System.out.println("Sort Student" + sortMapValues(getStudentMap(Student.getStudentList2())));
		
	}

	private static Map<String, Student> sortMapStreamValues(Map<String, Student> studentMap) {
		Map<String, Student> stu2 = (Map<String, Student>) studentMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue((student1, student2) -> {
					if (student1.getName().equals(student2.getName())) {
						return student1.getAge().compareTo(student2.getAge());
					} else {
						return student1.getName().compareTo(student2.getName());
					}
				}))
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(e1, e2) -> e2,
		                LinkedHashMap::new));
		return stu2;
	}

	private static Map<String, Student> sortMapValues(Map<String, Student> studentMap) {
		Set<Entry<String, Student>> entries = studentMap.entrySet();
		List<Entry<String, Student>> entriesList = new ArrayList<Entry<String, Student>>(entries);
		Collections.sort(entriesList, new Comparator<Entry<String,Student>>() {

			@Override
			public int compare(Entry<String, Student> arg0, Entry<String, Student> arg1) {
				return arg0.getValue().getName().compareTo(arg1.getValue().getName());
			}
        });
		Map<String, Student> mapFromSet = new LinkedHashMap<String, Student>();
	    for (Entry<String, Student> entry : entriesList) {
	        mapFromSet.put(entry.getKey(), entry.getValue());
	    }
		return mapFromSet;
	}
	
	private static Map<String, Student> sortMap(Map<String, Student> studentMap) {
		Set<Entry<String, Student>> entries = studentMap.entrySet();
		List<Entry<String, Student>> entriesList = new ArrayList<Entry<String, Student>>(entries);
		Collections.sort(entriesList, new Comparator<Entry<String,Student>>() {

			@Override
			public int compare(Entry<String, Student> arg0, Entry<String, Student> arg1) {
				return arg0.getKey().compareTo(arg1.getKey());
			}
            
            
        });
		Map<String, Student> mapFromSet = new LinkedHashMap();
	    for (Entry<String, Student> entry : entriesList) {
	        mapFromSet.put(entry.getKey(), entry.getValue());
	    }
		return mapFromSet;
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Student> sortMapStream(Map<String, Student> studentMap) {
		Map<String, Student> stu2 = (Map<String, Student>) studentMap.entrySet().stream()
										.sorted(Map.Entry.comparingByKey())
										.collect(Collectors.toMap(
												Map.Entry::getKey, 
												Map.Entry::getValue, 
												(e1, e2) -> e2,
								                LinkedHashMap::new));
		return stu2;
	}

	public static Map<String, Student> getStudentMap(ArrayList<Student> studentList) {
		
		Map<String, Student> stuMap = studentList.stream().collect(Collectors.toMap(
				Student::getSemister,
				Function.identity(),
				(e1, e2) -> e1,
				HashMap :: new));
		
		Map<String, Student> stuMap2 = studentList.stream().collect(Collectors.toMap(
				Student :: getSemister, 
				student -> student,
				(e1, e2) -> e2));
        
		return stuMap;
		
	} 
	
	private static ArrayList<Student> sortStream(ArrayList<Student> studentList) {
		studentList.sort((stu1, stu2) -> {
			if(stu1.getName().equals(stu2.getName())) {
				return stu1.getAge().compareTo(stu2.getAge());
			} else {
				return stu1.getName().compareTo(stu2.getName());
			}
		});
		return studentList;
	}
	
	private static ArrayList<Student> sortStream2(ArrayList<Student> studentList) {
		studentList = (ArrayList<Student>) studentList.stream().
								sorted(Comparator.comparing(Student :: getName).
										thenComparing(Student::getAge)).collect(Collectors.toList());
		return studentList;
	}

	private static ArrayList<Student> sortCollection(ArrayList<Student> studentList) {
		
		 studentList.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				if(o1.getName().equals(o2.getName())) {
					return o1.getAge().compareTo(o2.getAge());
				} else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		return studentList;
	}	
}
