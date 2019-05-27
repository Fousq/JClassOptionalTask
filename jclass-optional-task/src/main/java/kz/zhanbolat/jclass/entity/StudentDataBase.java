package kz.zhanbolat.jclass.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StudentDataBase {

    List<Student> students;

    public StudentDataBase() {
        students = new ArrayList<>();
    }

    public StudentDataBase(Student... students) {
        Stream.of(students).forEach(student -> this.students.add(student));
    }

    public StudentDataBase(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

}
