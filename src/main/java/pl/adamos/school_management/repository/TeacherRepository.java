package pl.adamos.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adamos.school_management.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findTeacherById(long id);

    Teacher findTeacherByLname(String lname);
}
