package Exceptions_Logging_Assignement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();


    @Test
    void addStudent_noExceptions_studentAdded() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");
        studentRepository.addStudent(student1);

        assertTrue(studentRepository.StudentByCNP.containsKey(student1.getID()));
    }

    @Test
    void addStudent_IllegalArguments_studentNotAdded() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1898, 7, 22), "M", "111111");
        try {
            studentRepository.addStudent(student1);
        } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        assertFalse(studentRepository.StudentByCNP.containsKey(student1.getID()));

    }

    @Test
    void addStudent_firstNameIsEmpty_throwNullPointerException() {

        Student student1 = new Student("", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");

        assertThrows(NullPointerException.class, () -> {
            studentRepository.addStudent(student1);
        });
    }

    @Test
    void addStudent_genderNotSupported_throwIllegalArgumentException() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "s", "111111");

        assertThrows(IllegalArgumentException.class, () -> {
            studentRepository.addStudent(student1);
        });
    }


    @Test
    void deleteStudent_noException_studentDeleted() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");
        studentRepository.StudentByCNP.put("111111", student1);

        System.out.println("Map contains: " + studentRepository);
        studentRepository.deleteStudent(student1);

        assertFalse(studentRepository.StudentByCNP.containsKey(student1.getID()));
    }

    @Test
    void deleteStudent_noSuchElementException_studentNotDeleted() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "");
        studentRepository.StudentByCNP.put("", student1);

        try {
            studentRepository.deleteStudent(student1);
        } catch (NoSuchElementException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        assertTrue(studentRepository.StudentByCNP.containsKey(student1.getID()));

    }


    @Test
    void getStudentsByAge_noExceptions_listReturned() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");
        Student student2 = new Student("Jude", "Bellingham", LocalDate.of(2003, 6, 29), "m", "222222");
        Student student3 = new Student("Eduardo", "Camavinga", LocalDate.of(2002, 11, 10), "M", "333333");
        Student student4 = new Student("Emma", "Raducanu", LocalDate.of(2002, 11, 13), "F", "444444");
        studentRepository.StudentByCNP.put("111111", student1);
        studentRepository.StudentByCNP.put("222222", student2);
        studentRepository.StudentByCNP.put("333333", student3);
        studentRepository.StudentByCNP.put("444444", student4);

        List<Student> studentsWithSpecificAge = studentRepository.getStudentsByAge(21);

        assertEquals(2, studentsWithSpecificAge.size());
    }

    @Test
    void getStudentsByAge_ageNegative_throwIllegalArgumentException() {

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");
        Student student2 = new Student("Jude", "Bellingham", LocalDate.of(2003, 6, 29), "m", "222222");
        Student student3 = new Student("Eduardo", "Camavinga", LocalDate.of(2002, 11, 10), "M", "333333");
        Student student4 = new Student("Emma", "Raducanu", LocalDate.of(2032, 11, 13), "F", "444444");
        studentRepository.StudentByCNP.put("111111", student1);
        studentRepository.StudentByCNP.put("222222", student2);
        studentRepository.StudentByCNP.put("333333", student3);
        studentRepository.StudentByCNP.put("444444", student4);

        assertThrows(IllegalArgumentException.class, () -> {
            studentRepository.getStudentsByAge(21);
        });
    }
}

