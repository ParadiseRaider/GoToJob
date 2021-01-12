package Lesson5;

import Lesson5.Service.StudentsIml;
import Lesson5.Service.StudentsRepository;
import Lesson5.model.Student;

public class Main {
    public static void main(String[] args) {
        StudentsRepository studentsRepository = new StudentsIml();

        if (studentsRepository.findAll().size()==0) {
            for (int i = 0; i < 1000; i++) {
                int randMark = (int) (Math.random() * 100 + 1);
                studentsRepository.createStudent(new Student("Student " + i, randMark));
            }
        }
        System.out.println("Количество студентов: " + studentsRepository.findAll().size());
        System.out.println(studentsRepository.findAll().toString());
    }
}
