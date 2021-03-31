package pl.adamos.school_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.SchoolSubject;
import pl.adamos.school_management.repository.SchoolSubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolSubjectService {

    private final SchoolSubjectRepository schoolSubjectRepository;

    public List<SchoolSubject> getSchoolSubjects(){
        return schoolSubjectRepository.findAll();
    }

    public SchoolSubject getSchoolSubjectById(long id){
        return schoolSubjectRepository.findSchoolSubjectById(id);
    }

    public SchoolSubject addSchoolSubject(SchoolSubject schoolSubject){
        return schoolSubjectRepository.save(schoolSubject);
    }

    public void deleteSchoolSubject(long id){
        schoolSubjectRepository.deleteById(id);
    }

}
