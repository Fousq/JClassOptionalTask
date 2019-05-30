package kz.zhanbolat.jclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.action.StudentListAction;
import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;
import kz.zhanbolat.jclass.generator.IdGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger(App.class);
    	StudentDataBase studentDB = new StudentDataBase();
        studentDB.add(new Student(IdGenerator.generateId(), "Orakbayev",
                                 "Zhanbolat", "Middle", "16.09.1999", "street",
                                 "8-888-88-88", "FIT", 2, "INF-22"));
        studentDB.add(new Student(IdGenerator.generateId(), "Surname", "Name",
                                 "Middle", "12.09.2000", "street",
                                 "8-888-88-88", "FMM", 2, "M-21"));
        studentDB.add(new Student(IdGenerator.generateId(), "S", "N", "M", 
                                "12.04.1997", "street", "8-888-88-88"));
        logger.info("Student list: ");
        studentDB.getStudents().forEach(student -> logger.info(student));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String faculty = null;
        try {
            logger.info("Enter the faculty: ");
            faculty = bf.readLine();
        } catch (IOException e) {
            logger.error("Got problem with bufferedReader");
            faculty = "Not defined";
        }
        List<Student> students = StudentListAction.getInstance().getStudentsByFaculty(studentDB.getStudents(), faculty);
        logger.info("Students of faculty " + faculty + ": ");
        students.forEach(student -> logger.info(student));
        students = StudentListAction.getInstance().getStudentsOfEveryFacultyAndYearOfStuding(studentDB.getStudents());
        logger.info("Students of every faculty and year of studing: ");
        students.forEach(student -> logger.info(student));
        int year = -1;
        try {
            logger.info("Enter the year: ");
            year = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            logger.error("Got problem with bufferedReader");
            year = 0;
        }
        students = StudentListAction.getInstance().getStudentsAfterYear(studentDB.getStudents(), year);
        logger.info("Students after year " + year + ": ");
        students.forEach(student -> logger.info(student));
        List<String> groups = StudentListAction.getInstance().getGroups(studentDB.getStudents());
        logger.info("Groups: ");
        groups.forEach(group -> logger.info(group));
    }
}
