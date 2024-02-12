package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import java12.entity.Course;
import java12.entity.Lesson;
import java12.repo.GenericRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepo implements GenericRepo<Lesson, Long> {

    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public LessonRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Lesson save(Lesson object) {
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
    public Lesson findById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Lesson lesson = null;

        try {
            entityManager.getTransaction().begin();

            lesson = entityManager.find(Lesson.class, aLong);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return lesson;
    }

    @Override
    public List<Lesson> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Lesson> lessons = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();

            lessons = entityManager.createQuery("select l from Lesson  l").getResultList();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return lessons;
    }

    @Override
    public Lesson updateById(Long aLong, Lesson newObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Lesson lesson = null;

        try {
            entityManager.getTransaction().begin();

            lesson = entityManager.find(Lesson.class, aLong);
            if (lesson != null) {
                lesson.setTitle(newObject.getTitle());
                lesson.setDescription(newObject.getDescription());
                lesson.setPublished(newObject.getPublished());
                lesson.setVideoLink(newObject.getVideoLink());
                lesson.setPresentation(newObject.isPresentation());
            }else {
                System.out.println("not found");
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return lesson;
    }

    @Override
    public void deleteById(Long aLong) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Lesson lesson = null;

        try {
            entityManager.getTransaction().begin();

            lesson = entityManager.find(Lesson.class, aLong);
            if (lesson != null){
                entityManager.remove(lesson);
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
