package kz.zhanbolat.jclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.diplay.DisplayStudentsAfterDate;
import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;

public class DisplayStudentsAfterDateTest {
	Logger logger = Logger.getLogger(getClass());
	StudentDataBase studentsDB = new StudentDataBase();
	
	@Before
	public void predata() {
		long counter = 0;
        studentsDB.add(new Student(++counter, "AA", "BB", "CC", "16.09.1999", "street", "8-701-212-43-43", "FIT", 1,
                "GIP-43"));
        studentsDB.add(new Student(++counter, "BB", "CC", "AA", "21.09.1999", "street", "8-701-212-43-43", "FMM", 1,
                "GIP-53"));
        studentsDB.add(new Student(++counter, "CC", "WW", "ZZ", "16.12.1997", "street", "8-701-212-43-43", "FIT", 1,
                "GIP-43"));
        studentsDB.add(new Student(++counter, "AA", "BB", "CC", "16.09.2001", "street", "8-701-212-43-43"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("16.09.2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DisplayStudentsAfterDate displayAfterDate = new DisplayStudentsAfterDate();
        displayAfterDate.display(studentsDB.getStudents(), date);
        displayAfterDate.display(studentsDB.getStudents(),"16.02.1998");
        displayAfterDate.display(studentsDB.getStudents(),1999);
        displayAfterDate.display(studentsDB.getStudents(),-1);
	}
	
}
