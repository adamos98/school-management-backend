package pl.adamos.school_management.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.adamos.school_management.model.Grade;

import java.util.List;

@Repository
public interface GradesRepository extends JpaRepository<Grade, Long> {

    Grade findById(long id);

    @Query("select g from Grade g" + " left join fetch g.student")
    List<Grade> findAllGrades();

    List<Grade> findGradesByStudentId(long id);

    List<Grade> findGradesByStudentSchoolGroupSign(String sign);

}
