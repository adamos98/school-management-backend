package pl.adamos.school_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.Teacher;
import pl.adamos.school_management.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Cacheable(cacheNames = "Teachers")
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    @Cacheable(cacheNames = "TeacherById", key = "#id")
    public Teacher getTeacherById(long id){
        return teacherRepository.findTeacherById(id);
    }

    public Teacher getTeacherByLname(String lname){
        return teacherRepository.findTeacherByLname(lname);
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @Transactional
    @CachePut(cacheNames = "TeacherById", key = "#result.id")
    public Teacher updateTeacher(Teacher teacher){
        Teacher teacherEdited = teacherRepository.findTeacherById(teacher.getId());
        teacherEdited.setEmail(teacher.getEmail());
        teacherEdited.setFname(teacher.getFname());
        teacherEdited.setLname(teacher.getLname());
        teacherEdited.setPassword(teacher.getPassword());
        return teacherEdited;
    }

    public void deleteTeacher(long id){
        teacherRepository.deleteById(id);
    }
}
