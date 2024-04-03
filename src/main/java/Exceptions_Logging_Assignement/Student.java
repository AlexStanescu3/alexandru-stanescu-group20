package Exceptions_Logging_Assignement;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String ID;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.ID = ID;
    }

    public int ageCalculator(Student student) {

        int studentAge = Period.between(student.getDateOfBirth(),java.time.LocalDate.now()).getYears();
        return studentAge;

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }



    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", ID='" + ID + '\'' +
                '}';
    }

    public void setID(String ID) {
        this.ID = ID;


    }
}

