package org.example.service;

import org.example.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void addStudentWithValidStudent() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void addStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(null));
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.addStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Student(1, "Alice", 15, 9.0));
        assertEquals("Age must be greater than 18", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidMark() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.addStudent(new Student(1, "Alice", 20, 11.0)));
        assertEquals("Mark must be between 0 and 10", exception.getMessage());
    }


    @Test
    void getStudentByIdWithValidId() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        assertEquals(student, studentService.getStudentById(1));
        assertEquals(Optional.of(student), studentService.getStudentByIdV2(1));
    }

    @Test
    void getStudentByIdWithInvalidId() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        assertNull(studentService.getStudentById(10));

        assertEquals(Optional.empty(), studentService.getStudentByIdV2(10));

    }

    @Test
    void getStudentByIdV2() {
    }



    @Test
    void updateStudentWithValidStudent() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        student.setName("Bob");
        student.setAge(21);
        student.setMark(8.0);
        studentService.updateStudent(student);

        assertEquals("Bob", studentService.getStudentById(1).getName());
        assertEquals(21, studentService.getStudentById(1).getAge());
        assertEquals(8.0, studentService.getStudentById(1).getMark());

    }

    @Test
    void updateStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(null));
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidId() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(new Student(2, "Bob", 21, 8.0)));
        assertEquals("Student with id 2 does not exist", exception.getMessage());

        Exception exceptionV2 = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudentV2(new Student(2, "Bob", 21, 8.0)));
        assertEquals("Student with id 2 does not exist", exceptionV2.getMessage());
    }

    @Test
    void updateStudentWithInvalidName() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidAge() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(new Student(1, "Alice", 17, 9.0)));
        assertEquals("Age must be greater than 18", exception.getMessage());
    }



    @Test
    void updateStudentV2() {
    }


    @Test
    void deleteStudentWithValidId() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        studentService.deleteStudent(1);
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void deleteStudentWithInvalidId() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);

        assertFalse(studentService.deleteStudent(10));
    }

    @Test
    void deleteStudentV2() {
    }

    @Test
    void getAllStudents() {
    }
}