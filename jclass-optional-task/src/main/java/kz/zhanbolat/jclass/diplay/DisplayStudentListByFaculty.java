package kz.zhanbolat.jclass.diplay;

import java.util.List;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.entity.Student;

public class DisplayStudentListByFaculty {
	private static Logger logger = Logger.getLogger(DisplayStudentListByFaculty.class);
	public static void display(List<Student> students, String faculty) {
		students.stream()
		 .filter(student -> faculty.equals(student.getFaculty()))
		 	.forEach(student -> logger
		 	  .info(student));
	}
	
}
