package pl.adamos.school_management.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.Grade;
import pl.adamos.school_management.repository.GradesRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradesRepository gradesRepository;

    public List<Grade> getGrades() {
        return gradesRepository.findAllGrades();
    }

    public Grade getGradeById(long id) {
        return gradesRepository.findById(id);
    }

    public List<Grade> getGradeByStudentId(long id){
        return gradesRepository.findGradesByStudentId(id);
    }

    public List<Grade> getGradesByStudentSchoolGroupSign(String sign){
        return gradesRepository.findGradesByStudentSchoolGroupSign(sign);
    }

    public Grade addGrade(Grade grades){
        return gradesRepository.save(grades);
    }

    @Transactional
    public Grade updateGrade(Grade grades){
        Grade gradeEdited = gradesRepository.findById(grades.getId());
        gradeEdited.setMark(grades.getMark());
        gradeEdited.setAnnotation(grades.getAnnotation());
        gradeEdited.setStudent(grades.getStudent());
        gradeEdited.setTeacher(grades.getTeacher());
        gradeEdited.setSchoolSubject(grades.getSchoolSubject());
        return gradeEdited;
    }

    public void deleteGrade(long id){
        gradesRepository.deleteById(id);
    }
}
