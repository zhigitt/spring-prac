package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import java12.entity.Course;
import java12.repo.GenericRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo implements GenericRepo<Course, Long> {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public CourseRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Course save(Course object) {
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
    public Course findById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;

        try {
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, aLong);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return course;
    }

    @Override
    public List<Course> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Course> course = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();

            course = entityManager.createQuery("select c from Course  c").getResultList();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return course;
    }

    @Override
    public Course updateById(Long aLong, Course newObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;

        try {
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, aLong);
            if (course != null) {
                course.setName(newObject.getName());
                course.setPrice(newObject.getPrice());
                course.setLessons(newObject.getLessons());
                course.setDateOfStart(newObject.getDateOfStart());
                course.setStudents(newObject.getStudents());
            }else {
                System.out.println("not found");
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return course;
    }

    @Override
    public void deleteById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;

        try {
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, aLong);
            if (course != null){
                entityManager.remove(course);
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
