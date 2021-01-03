package Lesson5.Service;

import Lesson5.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentsIml implements StudentsRepository {
    private final Session em;

    public StudentsIml() {
        em = getSessionFactory().openSession();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistry builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory();
    }

    @Override
    public void createStudent(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public Student getStudentByName(String name) {
        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.name = :nameStudent", Student.class)
                .setParameter("nameStudent",name).getResultList();
        for (Student s: students) {
            return s;
        }
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.id = :idStudent", Student.class)
                .setParameter("idStudent",id).getResultList();
        for (Student s: students) {
            return s;
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.id = :idStudent", Student.class)
                .setParameter("idStudent",student.getId()).getResultList();
        if (students!=null) {
            for (Student s: students) {
                if (s.getId().equals(student.getId())) {
                    s.setName(student.getName());
                    s.setMark(student.getMark());
                    em.getTransaction().begin();
                    em.persist(s);
                    em.getTransaction().commit();
                    em.clear();
                }
            }
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.id = :idStudent", Student.class)
                .setParameter("idStudent",student.getId()).getResultList();
        if (students!=null) {
            for (Student s: students) {
                if (s.getId().equals(student.getId())) {
                    em.getTransaction().begin();
                    em.remove(s);
                    em.getTransaction().commit();
                    em.clear();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }
}
