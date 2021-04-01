package pl.adamos.school_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.Student;
import pl.adamos.school_management.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Cacheable(cacheNames = "Students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentBySchoolGroupSign(String sign){
        return studentRepository.findStudentBySchoolGroupSign(sign);
    }

    @Cacheable(cacheNames = "StudentById", key = "#id")
    public Student getStudentById(long id){
        return studentRepository.findStudentById(id);
    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    @CachePut(cacheNames = "StudentById", key = "#result.id")
    public Student updateStudent(Student student){
        Student studentEdited = studentRepository.findStudentById(student.getId());
        studentEdited.setEmail(student.getEmail());
        studentEdited.setPassword(student.getPassword());
        studentEdited.setFname(student.getFname());
        studentEdited.setLname(student.getLname());
        studentEdited.setSchoolGroup(student.getSchoolGroup());
        return studentEdited;
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

}
