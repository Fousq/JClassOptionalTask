package kz.zhanbolat.jclass.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.entity.Student;

public class StudentListAction {

    private static StudentListAction studentListAction;
    private static Logger logger = Logger.getLogger(StudentListAction.class);

    public static StudentListAction getInstance() {
        if (studentListAction == null) {
            studentListAction = new StudentListAction();
        }
        return studentListAction;
    }

    public List<Student> getStudentsByFaculty(List<Student> students, String faculty) {
        return students.stream().filter(student -> faculty.equals(student.getFaculty())).collect(Collectors.toList());
    }

    public List<Student> getStudentsOfEveryFacultyAndYearOfStuding(List<Student> students) {
        List<Student> sortedList = new ArrayList<>(Collections.unmodifiableList(students));
        Collections.sort(sortedList, new SortByFacultyAndYearOfStuding());
        return sortedList;
    }

    public class SortByFacultyAndYearOfStuding implements Comparator<Student>{

        @Override
        public int compare(Student student1, Student student2) {
            return (student1.getFaculty().compareTo(student2.getFaculty())) 
                    + (student1.getYearOfStuding() - student2.getYearOfStuding());
        }
    
    }

    public List<Student> getStudentsAfterYear(List<Student> students, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        List<Student> studentsAfterYear = new ArrayList<>();
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
                studentsAfterYear.add(student);
            }
        }
        return studentsAfterYear;
    }

    public List<Student> getStudentsAfterYear(List<Student> students, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch(ParseException e) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedDate);
        int year = cal.get(Calendar.YEAR);
        List<Student> studentsAfterYear = new ArrayList<>();
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
                studentsAfterYear.add(student);
            }
        }
        return studentsAfterYear;
    }

    public List<Student> getStudentsAfterYear(List<Student> students, int year) throws IllegalArgumentException {
        if (year < 0) {
            logger.error("Year must not be negative");
            throw new IllegalArgumentException();
        }
        List<Student> studentsAfterYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Student student : students) {
            cal.setTime(student.getDateOfBirth());
            if (cal.get(Calendar.YEAR) > year) {
                studentsAfterYear.add(student);
            }
        }
        return studentsAfterYear;
    }

    public List<String> getGroups(List<Student> students) {
        List<String> groups = new ArrayList<>();
        for(Student student : students) {
            if (!groups.contains(student.getGroup()) 
                && !student.getGroup().equals("Not defined")) {
                groups.add(student.getGroup());
            }
        }
        return groups;
    }

}
