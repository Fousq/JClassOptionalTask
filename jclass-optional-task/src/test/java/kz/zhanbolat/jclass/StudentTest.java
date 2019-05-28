package kz.zhanbolat.jclass;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kz.zhanbolat.jclass.entity.Student;

public class StudentTest {

    Logger logger = Logger.getLogger(getClass());

    @Test
    @Ignore("successfully pass")
    public void constructorTest() {
        logger.info("-----------ConstructorTest---------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse("16.09.1999");
        } catch (ParseException e) {
            dateOfBirth = new Date();
        }
        Student student = new Student(1L, "foo", "bar", "foobar", dateOfBirth,
                                    "street", "8-701-123-13-32", "FIT", 1,
                                    "INF-12");
        logger.info("student id: " + student.getStudentId());
        logger.info("surname: " + student.getSurname());
        logger.info("name: " + student.getName());
        logger.info("middle name: " + student.getMiddleName());
        logger.info("date of birth: " + student.getDateOfBirth());
        logger.info("address: " + student.getAddress());
        logger.info("telephone number: " + student.getTelephoneNumber());
        logger.info("faculty: " + student.getFaculty());
        logger.info("year of studing: " + student.getYearOfStuding());
        logger.info("group: " + student.getGroup());
        try {
            dateOfBirth = dateFormat.parse("21.01.1999");
        } catch (ParseException e) {
            dateOfBirth = new Date();
        }
        student = new Student(2L, "bar", "foo", "cypher", dateOfBirth,
                                "another", "8-771-323-34-42");
        logger.info("student id: " + student.getStudentId());
        logger.info("surname: " + student.getSurname());
        logger.info("name: " + student.getName());
        logger.info("middle name: " + student.getMiddleName());
        logger.info("date of birth: " + student.getDateOfBirth());
        logger.info("address: " + student.getAddress());
        logger.info("telephone number: " + student.getTelephoneNumber());
        logger.info("faculty: " + student.getFaculty());
        logger.info("year of studing: " + student.getYearOfStuding());
        logger.info("group: " + student.getGroup());
        logger.info("-----------ConstructorTest---------------");
    }

    @Test
    @Ignore("succesfully pass")
    public void constructorShouldNotifyAboutException() {
        Student student = new Student(1L, "foo", "bar", "foobar", "12.12.1999",
                                    "street", "8-701-123-13-32", "FIT", 1,
                                    "INF-12");
        logger.info(student.getDateOfBirth());
    }

}
