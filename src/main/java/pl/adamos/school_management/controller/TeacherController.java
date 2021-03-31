package pl.adamos.school_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adamos.school_management.model.Teacher;
import pl.adamos.school_management.service.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id);
    }
    @GetMapping("/teachers/lname/{lname}")
    public Teacher getTeacherByLname(@PathVariable String lname){
        return teacherService.getTeacherByLname(lname);
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("teachers/{id}")
    public void deleteTeacher(@PathVariable long id){
        teacherService.deleteTeacher(id);
    }


}
