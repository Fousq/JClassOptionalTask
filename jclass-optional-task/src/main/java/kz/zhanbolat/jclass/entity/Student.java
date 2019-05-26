package kz.zhanbolat.jclass.entity;

import java.util.Date;

public class Student {

    private Long studentId;
    private String surname;
    private String name;
    private String middleName;
    private Date dateOfBirth;
    private String address;
    private String telephoneNumber;
    private String faculty;
    private short yearOfStuding;
    private String group;

    public Student() {

    }

    public Long getStudentId() {
        return studentId;
    }

    public short getYearOfStuding() {
        return yearOfStuding;
    }

    public void setYearOfStuding(short yearOfStuding) {
        this.yearOfStuding = yearOfStuding;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", date of birth=" + dateOfBirth
                 + ", faculty=" + faculty + ", group=" + group + ", middle name="
                 + middleName + ", name=" + name + ", studentId=" + studentId
                 + ", surname=" + surname + ", telephone number=" + telephoneNumber
                 + ", year of studing=" + yearOfStuding + "]";
    }

}
