package Lesson5.Service;

import Lesson5.model.Student;

import java.util.List;

public interface StudentsRepository {
    void createStudent(Student student);
    Student getStudentByName(String name);
    Student getStudentById(Long id);
    void updateStudent(Student student);
    boolean deleteStudent(Student student);
    List<Student> findAll();
}
