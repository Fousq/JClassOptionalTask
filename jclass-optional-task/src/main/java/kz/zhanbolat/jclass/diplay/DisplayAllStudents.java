package kz.zhanbolat.jclass.diplay;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.entity.Student;

public class DisplayAllStudents {
	private static Logger logger = Logger.getLogger(DisplayAllStudents.class.getName());
	public static void display(List<Student> students) {
		List<Student> sorted = students
				.stream()
				 .filter(student -> 
					!student.getFaculty().equals("Not defined")
					 && !student.getGroup().equals("Not defined")
					  && student.getYearOfStuding() != 0)
				 		.collect(Collectors.toList());
		sorted.sort((Student student1, Student student2) -> 
						student1.getFaculty().compareTo(student2.getFaculty())
							+ student1.getYearOfStuding()
								.compareTo(student2.getYearOfStuding()));
		sorted.forEach(student -> logger.info(student));
	}
	
}
