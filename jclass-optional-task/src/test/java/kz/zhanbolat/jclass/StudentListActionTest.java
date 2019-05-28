package kz.zhanbolat.jclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;
import kz.zhanbolat.jclass.action.StudentListAction;

public class StudentListActionTest {

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
    @Ignore("succesfully pass")
    public void getStudentsByFacultyTest() {
        logger.info("----------getStudentsByFaculty------------");
        List<Student> students = StudentListAction.getInstance().getStudentsByFaculty(studentsDB.getStudents(), "FIT");
        logger.info("FIT students: ");
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance().getStudentsByFaculty(studentsDB.getStudents(), "FMM");
        logger.info("FMM students: ");
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance().getStudentsByFaculty(studentsDB.getStudents(), "Not defined");
        logger.info("Not defined students: ");
        students.forEach(student -> logger.info(student));
        logger.info("----------getStudentsByFaculty------------");
    }

    @Test
    @Ignore
    public void getStudentsOfEveryFacultyAndYearOfStudingTest() {
        logger.info("------getStudentsOfEveryFacultyAndYearOfStuding--------");
        List<Student> students = StudentListAction.getInstance()
                .getStudentsOfEveryFacultyAndYearOfStuding(studentsDB.getStudents());
        students.forEach(student -> logger.info(student));
        logger.info("------getStudentsOfEveryFacultyAndYearOfStuding--------");
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void getStudentsAfterYearTest() {
        logger.info("-------------getStudentsAfterYear---------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("16.09.2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Student> students = StudentListAction.getInstance()
                                                .getStudentsAfterYear(studentsDB.getStudents()
                                                                    , date);
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance()
                                        .getStudentsAfterYear(studentsDB.getStudents(),
                                                            "16.02.1998");
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance()
                                        .getStudentsAfterYear(studentsDB.getStudents(),
                                                            1999);
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance()
                                        .getStudentsAfterYear(studentsDB.getStudents(),
                                                                -1);
        logger.info("-------------getStudentsAfterYear---------------------");
    }

    @Test
    @Ignore
    public void getGropsTest() {
        logger.info("------------getGroups------------------");
        List<String> groups = StudentListAction.getInstance().getGroups(studentsDB.getStudents());
        groups.forEach(group -> logger.info(group));
        logger.info("------------getGroups-------------------");
    }

}
