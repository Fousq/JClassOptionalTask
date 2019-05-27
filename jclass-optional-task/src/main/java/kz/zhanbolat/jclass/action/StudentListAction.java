package kz.zhanbolat.jclass.action;

import java.util.List;
import java.util.stream.Collectors;

import kz.zhanbolat.jclass.entity.Student;

public class StudentListAction {

    private static StudentListAction studentListAction;

    public static StudentListAction getInstance() {
        if (studentListAction == null) {
            studentListAction = new StudentListAction();
        }
        return studentListAction;
    }

    public List<Student> getStudentsByFaculty(List<Student> students,
                                             String faculty) {
        return students
                .stream()
                 .filter(student -> faculty.equals(student.getFaculty()))
                  .collect(Collectors.toList());
    }

}
