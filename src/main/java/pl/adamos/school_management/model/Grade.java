package pl.adamos.school_management.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long mark;
    private String annotation;

    @ManyToOne
    @JoinColumn(name = "schoolSubjectId")
    private SchoolSubject schoolSubject;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
}
