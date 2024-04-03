package Exceptions_Logging_Assignement;

import java.time.LocalDate;
import java.util.NoSuchElementException;

public class MainExceptions {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Fede", "Valverde", LocalDate.of(1998, 7, 22), "M", "111111");
        Student student2 = new Student("Jude", "Bellingham", LocalDate.of(2003, 6, 29), "m", "222222");
        Student student3 = new Student("Eduardo", "Camavinga", LocalDate.of(2002, 11, 10), "M", "333333");
        Student student4 = new Student("Emma", "Raducanu", LocalDate.of(2002, 11, 13), "F", "444444");
        // Student student5 = new Student("", "", LocalDate.of(2027, 11,13),"", "");
        try {
            studentRepository.addStudent(student1);
            studentRepository.addStudent(student2);
            studentRepository.addStudent(student3);
            studentRepository.addStudent(student4);
            System.out.println("Added students: ");
            System.out.println(studentRepository.StudentByCNP);
            // studentRepository.StudentByCNP.put(student5.getID(),student5);

            System.out.println();
            studentRepository.deleteStudent(student2);
            System.out.println("Map after some students are deleted: ");
            System.out.println(studentRepository.StudentByCNP);

            System.out.println();
            System.out.println("Students with age 21");
            System.out.println(studentRepository.getStudentsByAge(21));

            System.out.println();
            System.out.println("Students ordered by Last Name: ");
            studentRepository.listStudentsSortedByLastName();

            System.out.println();
            System.out.println("Students ordered by Birth Date: ");
            studentRepository.listStudentsSortedByBirthDate();

        } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }


    }


}

