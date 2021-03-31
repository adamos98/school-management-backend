package pl.adamos.school_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adamos.school_management.model.SchoolSubject;
import pl.adamos.school_management.service.SchoolSubjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolSubjectController {

    private final SchoolSubjectService schoolSubjectService;

    @GetMapping("/schoolsubjects")
    public List<SchoolSubject> getSchoolSubject(){
        return schoolSubjectService.getSchoolSubjects();
    }

    @GetMapping("/schoolsubjects/{id}")
    public SchoolSubject getSchoolSubjectById(@PathVariable long id){
        return schoolSubjectService.getSchoolSubjectById(id);
    }

    @PostMapping("/schoolsubjects")
    public SchoolSubject addSchoolSubject(@RequestBody SchoolSubject schoolSubject){
        return schoolSubjectService.addSchoolSubject(schoolSubject);
    }

    @DeleteMapping("/schoolsubjects/{id}")
    public void deleteSchoolSubject(@PathVariable long id){
        schoolSubjectService.deleteSchoolSubject(id);
    }

}
