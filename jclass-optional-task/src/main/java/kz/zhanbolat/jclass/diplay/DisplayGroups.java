package kz.zhanbolat.jclass.diplay;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.entity.Student;

public class DisplayGroups {
	private static Logger logger = Logger.getLogger(DisplayGroups.class.getName());
	
	public static void display(List<Student> students) {
        List<String> groups = new ArrayList<>();
        for(Student student : students) {
            if (!groups.contains(student.getGroup()) 
                && !student.getGroup().equals("Not defined")) {
                groups.add(student.getGroup());
            }
        }
        groups.stream().forEach(group -> logger.info(group));
    }
	
}
