package java12.service.impl;

import java12.entity.Course;
import java12.repo.impl.CourseRepo;
import java12.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService implements GenericService<Course, Long> {

//    @Autowired
//    @Qualifier("courseRepo")
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course save(Course object) {
        return courseRepo.save(object);
    }

    @Override
    public Course findById(Long aLong) {
        return courseRepo.findById(aLong);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course updateById(Long aLong, Course newObject) {
        return courseRepo.updateById(aLong, newObject);
    }

    @Override
    public void deleteById(Long aLong) {
        courseRepo.deleteById(aLong);
    }
}
