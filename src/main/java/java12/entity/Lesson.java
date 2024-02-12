package java12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    private String videoLink;

    @Column(name = "published_date")
    private LocalDate published;

    private boolean isPresentation;

    public Lesson(String title, String description, String videoLink, LocalDate published, boolean isPresentation) {
        this.title = title;
        this.description = description;
        this.videoLink = videoLink;
        this.published = published;
        this.isPresentation = isPresentation;
    }

    @Override
    public String toString() {
        return "Lesson{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", videoLink='" + videoLink + '\'' +
               ", published=" + published +
               ", isPresentation=" + isPresentation +
               '}';
    }
}
