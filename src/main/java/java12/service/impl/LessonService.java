package java12.service.impl;

import java12.entity.Lesson;
import java12.repo.impl.LessonRepo;
import java12.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements GenericService<Lesson, Long> {

    private  final LessonRepo lessonRepo;

    public LessonService(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }


    @Override
    public Lesson save(Lesson object) {
        return lessonRepo.save(object);
    }

    @Override
    public Lesson findById(Long aLong) {
        return lessonRepo.findById(aLong);
    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepo.getAll();
    }

    @Override
    public Lesson updateById(Long aLong, Lesson newObject) {
        return lessonRepo.updateById(aLong, newObject);
    }

    @Override
    public void deleteById(Long aLong) {
        lessonRepo.deleteById(aLong);
    }
}
