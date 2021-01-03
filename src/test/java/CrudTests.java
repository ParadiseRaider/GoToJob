import Lesson5.Service.StudentsIml;
import Lesson5.Service.StudentsRepository;
import Lesson5.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrudTests {
    private final StudentsRepository studentsRepository;
    private final String NAME = "Vova";
    private final String UPDATENAME = "Igor";

    public CrudTests() {
        this.studentsRepository = new StudentsIml();
    }

    @Test
    public void createTest() {
        int size1 = studentsRepository.findAll().size();
        studentsRepository.createStudent(new Student(NAME,99));
        Student student = studentsRepository.getStudentByName(NAME);
        int size2 = studentsRepository.findAll().size();
        Assertions.assertEquals(size1+1,size2);
        studentsRepository.deleteStudent(student);
    }

    @Test
    public void readTest() {
        studentsRepository.createStudent(new Student(NAME,99));
        Student student = studentsRepository.getStudentByName(NAME);
        Assertions.assertEquals(student.getName(),NAME);
        studentsRepository.deleteStudent(student);
    }

    @Test
    public void updateTest() {
        studentsRepository.createStudent(new Student(NAME,99));
        Student student = studentsRepository.getStudentByName(NAME);
        student.setName(UPDATENAME);
        student.setMark(77);
        studentsRepository.updateStudent(student);
        Student updateStudent = studentsRepository.getStudentByName(UPDATENAME);
        Assertions.assertEquals(student.getName(), updateStudent.getName());
        studentsRepository.deleteStudent(student);
    }

    @Test
    public void deleteTest() {
        studentsRepository.createStudent(new Student(NAME,99));
        Student student = studentsRepository.getStudentByName(NAME);
        Assertions.assertTrue(studentsRepository.deleteStudent(student));
    }
}
