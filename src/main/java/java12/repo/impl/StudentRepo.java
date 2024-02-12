package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import java12.entity.Course;
import java12.entity.Lesson;
import java12.entity.Student;
import java12.repo.GenericRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo implements GenericRepo<Student, Long> {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public StudentRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Student save(Student object) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    }

    @Override
    public Student findById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, aLong);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();

            students = entityManager.createQuery("select s from Student  s").getResultList();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return students;
    }

    @Override
    public Student updateById(Long aLong, Student newObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, aLong);
            if (student != null) {
                student.setName(newObject.getName());
                student.setEmail(newObject.getEmail());
                student.setCourse(newObject.getCourse());
                student.setYearOfBirth(newObject.getYearOfBirth());
            }else {
                System.out.println("not found");
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return newObject;
    }

    @Override
    public void deleteById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, aLong);
            if (student != null){
                entityManager.remove(student);
            }else {
                System.out.println("not found");
            }

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        System.out.println("deleted");
    }
}
