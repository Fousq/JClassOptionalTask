package kz.zhanbolat.jclass;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.diplay.DisplayAllStudents;
import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;

public class DisplayAllStudentsTest {
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
	
	@Test
	public void test() {
		DisplayAllStudents.display(studentsDB.getStudents());
	}
	
}
