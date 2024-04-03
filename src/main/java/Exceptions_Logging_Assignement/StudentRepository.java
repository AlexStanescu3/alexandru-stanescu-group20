package Exceptions_Logging_Assignement;

import java.time.Period;
import java.util.*;

public class StudentRepository {

    Map<String, Student> StudentByCNP = new HashMap<>();

    public void addStudent(Student student) {

        if (student.getDateOfBirth().getYear() < 1900 || java.time.LocalDate.now().getYear() - 18 < student.getDateOfBirth().getYear()) {

            throw new IllegalArgumentException("Date of birth should be between 1900 and current year - 18 ");
        }

        if (student.getFirstName() == null || student.getLastName() == null || student.getFirstName().isBlank() || student.getLastName().isBlank()) {

            throw new NullPointerException("First name and last name should not be empty");
        }

        if (student.getGender() != "M" && student.getGender() != "F" && student.getGender() != "male" && student.getGender() != "female" && student.getGender() != "m" && student.getGender() != "f") {

            throw new IllegalArgumentException("There are only two genders: Male or Female");
        }
        this.StudentByCNP.put(student.getID(), student);

    }

    public void deleteStudent(Student student) {

        if (student.getID().isEmpty() || student.getID() == null) {

            throw new NoSuchElementException("ID is empty, student does not exist");
        }

        this.StudentByCNP.remove(student.getID());

    }


    public List<Student> getStudentsByAge(int age) {

        List<Student> studentsWithAge = new ArrayList<>();

        for (Student student : StudentByCNP.values()) {
            int calculatedAge = student.ageCalculator(student);

            if (calculatedAge != (int) calculatedAge || calculatedAge < 0) {

                throw new IllegalArgumentException("Age should be a number and should be positive ");
            }

            if (student.ageCalculator(student) == age) {
                studentsWithAge.add(student);
            }

        }
        return studentsWithAge;

    }

    public void listStudentsSortedByLastName() {
        List<Student> students = new ArrayList<>(StudentByCNP.values());
        Collections.sort(students, Comparator.comparing(Student::getLastName));
        throwException(students);
        printStudents(students);
    }

    public void listStudentsSortedByBirthDate() {
        List<Student> students = new ArrayList<>(StudentByCNP.values());
        Collections.sort(students, Comparator.comparing(Student::getDateOfBirth));
        throwException(students);
        printStudents(students);

    }

    private static void throwException(List<Student> students) {
        for (Student student : students) {
            if (student.getID().isBlank() || student.getID() == null) {
                throw new NoSuchElementException("ID is empty, student does not exist");
            }
        }
    }

    private void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }


    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "StudentByCNP=" + StudentByCNP +
                '}';
    }
}
