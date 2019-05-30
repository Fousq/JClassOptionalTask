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
    	this.students = new ArrayList<>();
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
    
    public void setStudents(Student... students) {
    	this.students.clear();
    	Stream.of(students).forEach(student -> this.students.add(student));
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

	@Override
	public String toString() {
		return "StudentDataBase [students=" + students + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDataBase other = (StudentDataBase) obj;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

}
