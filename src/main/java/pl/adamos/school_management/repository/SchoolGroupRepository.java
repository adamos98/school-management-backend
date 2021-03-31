package pl.adamos.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamos.school_management.model.SchoolGroup;

@Repository
public interface SchoolGroupRepository extends JpaRepository<SchoolGroup,Long> {

    SchoolGroup findSchoolGroupById(long id);

}
