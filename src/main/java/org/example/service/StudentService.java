package org.example.service;

import org.example.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        students.add(student);
    }

    public Student getStudentById(long id) {

        for (Student student: students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public Optional<Student>  getStudentByIdV2(long id) {

        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public void updateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
            else {
                throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist");
            }
        }
    }

    public void updateStudentV2(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        Optional<Student> existingStudent = getStudentByIdV2(student.getId());
        if (existingStudent.isPresent()) {
            students.set(students.indexOf(existingStudent.get()), student);
        } else {
            throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist");
        }

    }

    public boolean deleteStudent(long id) {

        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean deleteStudentV2(long id) {

        return students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {

        return new ArrayList<>(students);
    }


}
