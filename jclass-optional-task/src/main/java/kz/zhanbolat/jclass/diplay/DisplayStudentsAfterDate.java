package kz.zhanbolat.jclass.diplay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.entity.Student;

public class DisplayStudentsAfterDate {
	private static Logger logger = Logger.getLogger(DisplayStudentsAfterDate.class);
	private final Calendar cal = Calendar.getInstance();
	
	public void display(List<Student> students, Date date) {
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
                logger.info(student);
            }
        }
    }

    public void display(List<Student> students, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch(ParseException e) {
        	logger.error("Got during parsing the string to date. Please recheck the string.");
            return;
        }
        cal.setTime(parsedDate);
        int year = cal.get(Calendar.YEAR);
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
            	logger.info(student);
            }
        }
    }

    public void display(List<Student> students, int year) throws IllegalArgumentException {
        if (year < 0) {
        	logger.error("Year must not be negative");
            throw new IllegalArgumentException();
        };
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
            	logger.info(student);
            }
        }
    }
	
}
