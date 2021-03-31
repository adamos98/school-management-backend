package pl.adamos.school_management.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String fname;
    private String lname;

    @ManyToOne
    @JoinColumn(name = "schoolGroupId")
    private SchoolGroup schoolGroup;
}
