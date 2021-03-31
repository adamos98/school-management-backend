package pl.adamos.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamos.school_management.model.SchoolSubject;

@Repository
public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, Long> {
    SchoolSubject findSchoolSubjectById(long id);

}
