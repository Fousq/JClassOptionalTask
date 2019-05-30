package kz.zhanbolat.jclass.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Student {
    private static SimpleDateFormat dateFormat = 
                                new SimpleDateFormat("dd.MM.yyyy");
    private static Logger logger = Logger.getLogger(Student.class);
    private Long studentId;
    private String surname;
    private String name;
    private String middleName;
    private Date dateOfBirth;
    private String address;
    private String telephoneNumber;
    private String faculty;
    private Integer yearOfStuding;
    private String group;
    static {
        dateFormat.setLenient(false);
    }

    public Student(Long studentId, String surname, String name,
                    String middleName, Date dateOfBirth, String address,
                    String telephoneNumber, String faculty, 
                    Integer yearOfStuding, String group) {
        this.studentId = studentId;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.faculty = faculty;
        this.yearOfStuding = yearOfStuding;
        this.group = group;
    }

    public Student(Long studentId, String surname, String name,
                    String middleName, String dateOfBirth, String address,
                    String telephoneNumber, String faculty, 
                    Integer yearOfStuding, String group) {
        this.studentId = studentId;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        try{
            this.dateOfBirth = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            logger.error("Not be able to parse into date. Date of birth will set "
                        + "to current date.");
            this.dateOfBirth = new Date();
        }
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.faculty = faculty;
        this.yearOfStuding = yearOfStuding;
        this.group = group;
    }

    public Student(Long studentId, String surname, String name,
                    String middleName, Date dateOfBirth, String address,
                    String telephoneNumber) {
        this.studentId = studentId;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        faculty = "Not defined";
        yearOfStuding = 0;
        group = "Not defined";
    }

    public Student(Long studentId, String surname, String name,
                    String middleName, String dateOfBirth, String address,
                    String telephoneNumber) {
        this.studentId = studentId;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        try{
            this.dateOfBirth = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            logger.error("Not be able to parse into date. Date of birth will set "
                        + "to current date.");
            this.dateOfBirth = new Date();
        }
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        faculty = "Not defined";
        yearOfStuding = 0;
        group = "Not defined";
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYearOfStuding() {
        return yearOfStuding;
    }

    public void setYearOfStuding(Integer yearOfStuding) {
        this.yearOfStuding = yearOfStuding;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", date of birth=" + dateOfBirth
                 + ", faculty=" + faculty + ", group=" + group + ", middle name="
                 + middleName + ", name=" + name + ", studentId=" + studentId
                 + ", surname=" + surname + ", telephone number=" + telephoneNumber
                 + ", year of studing=" + yearOfStuding + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result + ((yearOfStuding == null) ? 0 : yearOfStuding.hashCode());
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
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		if (yearOfStuding == null) {
			if (other.yearOfStuding != null)
				return false;
		} else if (!yearOfStuding.equals(other.yearOfStuding))
			return false;
		return true;
	}
    
}
