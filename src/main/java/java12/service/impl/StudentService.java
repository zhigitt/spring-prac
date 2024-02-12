package java12.service.impl;

import java12.entity.Student;
import java12.repo.GenericRepo;
import java12.repo.impl.StudentRepo;
import java12.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements GenericService<Student, Long> {

    private  final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student save(Student object) {
        return studentRepo.save(object);
    }

    @Override
    public Student findById(Long aLong) {
        return studentRepo.findById(aLong);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student updateById(Long aLong, Student newObject) {
        return studentRepo.updateById(aLong, newObject);
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
