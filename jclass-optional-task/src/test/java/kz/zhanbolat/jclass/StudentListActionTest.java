package kz.zhanbolat.jclass;

import org.apache.log4j.Logger;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.StudentDataBase;

public class StudentListActionTest {

    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getStudentsByFacultyTest() {
        logger.info("----------getStudentsByFaculty------------");
        long counter = 0;
        StudentDataBase studentsDB = new StudentDataBase();
        studentsDB.add(new Student(counter++,"AA", "BB", "CC", ));
        logger.info("----------getStudentsByFaculty------------");
    }

}
