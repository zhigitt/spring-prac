package java12;

import java12.config.Config;
import java12.entity.Course;
import java12.entity.Lesson;
import java12.entity.Student;
import java12.service.impl.CourseService;
import java12.service.impl.LessonService;
import java12.service.impl.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CourseService courseService = context.getBean(CourseService.class);
        StudentService studentService = context.getBean(StudentService.class);
        LessonService lessonService = context.getBean(LessonService.class);


        //Course
//        courseService.save(new Course("Peaksoft",14000, LocalDate.of(2019,4,5)));
//        System.out.println(courseService.findById(2L));
//        System.out.println(courseService.getAll());
//        System.out.println(courseService.updateById(2L, new Course("Flutter", 14000, LocalDate.of(2019, 4, 5))));
//        courseService.deleteById(2L);

        //Student
//        System.out.println(studentService.save(new Student("Mirlan", "m@gmail.com", LocalDate.of(2002,12,12))));
//        System.out.println(studentService.findById(3L));
//        System.out.println(studentService.getAll());
//        studentService.deleteById(3L);

        //Lesson
//        System.out.println(lessonService.save(new Lesson("English", "asdasd", "aaa", LocalDate.of(2023, 01,01), true)));
//        System.out.println(lessonService.findById(1L));
//        System.out.println(lessonService.findById(1L));
//        System.out.println(lessonService.getAll());
//        lessonService.deleteById(1L);
    }
}
