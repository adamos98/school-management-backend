package pl.adamos.school_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adamos.school_management.model.Student;
import pl.adamos.school_management.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/schoolgroup/{sign}")
    public List<Student> getStudentsBySchoolGroupSign(@PathVariable String sign){
        return studentService.getStudentBySchoolGroupSign(sign);
    }

    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }

}
