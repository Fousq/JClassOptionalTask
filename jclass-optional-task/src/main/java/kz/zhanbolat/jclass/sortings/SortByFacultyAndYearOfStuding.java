package kz.zhanbolat.jclass.sortings;

import java.util.Comparator;

import kz.zhanbolat.jclass.entity.Student;

public class SortByFacultyAndYearOfStuding implements Comparator<Student>{

    public int compare(Student student1, Student student2) {
        return (student1.getFaculty().compareTo(student2.getFaculty())) 
                + (student1.getYearOfStuding() - student2.getYearOfStuding());
    }

}
