package kz.zhanbolat.jclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.diplay.DisplayAllStudents;
import kz.zhanbolat.jclass.diplay.DisplayGroups;
import kz.zhanbolat.jclass.diplay.DisplayStudentListByFaculty;
import kz.zhanbolat.jclass.diplay.DisplayStudentsAfterDate;
import kz.zhanbolat.jclass.entity.Student;
import kz.zhanbolat.jclass.entity.StudentDataBase;
import kz.zhanbolat.jclass.generator.IdGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
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
        logger.info("Students of faculty " + faculty + ": ");
        DisplayStudentListByFaculty.display(studentDB.getStudents(), faculty);
        logger.info("Students of every faculty and year of studing: ");
        DisplayAllStudents.display(studentDB.getStudents());
        int year = -1;
        try {
            logger.info("Enter the year: ");
            year = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            logger.error("Got problem with bufferedReader");
            year = 0;
        }
        logger.info("Students after year " + year + ": ");
        new DisplayStudentsAfterDate().display(studentDB.getStudents(), year);
        logger.info("Groups: ");
        DisplayGroups.display(studentDB.getStudents());
    }
}
