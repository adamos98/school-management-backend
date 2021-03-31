package pl.adamos.school_management.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adamos.school_management.model.Grade;
import pl.adamos.school_management.service.GradeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradesService;

    @GetMapping("/grades")
    public List<Grade> getGrades(){
        return gradesService.getGrades();
    }

    @GetMapping("/grades/{id}")
    public Grade getSingleGrade(@PathVariable long id){
       return gradesService.getGradeById(id);
    }

    @GetMapping("/grades/students/{id}")
    public List<Grade> getSingleGradeByStudentId(@PathVariable long id){
        return gradesService.getGradeByStudentId(id);
    }

    @GetMapping("/grades/students/schoolgroup/{sign}")
    public List<Grade> getGradesByStudentSchoolGroupSign(@PathVariable String sign){
        return gradesService.getGradesByStudentSchoolGroupSign(sign);
    }

    @PostMapping("/grades")
    public Grade addGrade(@RequestBody Grade grades){
        return gradesService.addGrade(grades);
    }

    @PutMapping("/grades")
    public Grade updateGrade(@RequestBody Grade grade){
        return gradesService.updateGrade(grade);
    }

    @DeleteMapping("/grades/{id}")
    public void deleteGrade(@PathVariable long id){
        gradesService.deleteGrade(id);
    }

}
