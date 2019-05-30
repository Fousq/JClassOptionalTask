package kz.zhanbolat.jclass;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.diplay.DisplayStudentListByFaculty;
import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;

public class DisplayStudentListByFacultyTest {
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
		logger.info("FIT students: ");
		DisplayStudentListByFaculty.display(studentsDB.getStudents(), "FIT");
		logger.info("FMM students: ");
        DisplayStudentListByFaculty.display(studentsDB.getStudents(), "FMM");
        logger.info("Not defined students: ");
        DisplayStudentListByFaculty.display(studentsDB.getStudents(), "Not defined");
	}
	
}
