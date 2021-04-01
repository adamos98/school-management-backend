package pl.adamos.school_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.SchoolSubject;
import pl.adamos.school_management.repository.SchoolSubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolSubjectService {

    private final SchoolSubjectRepository schoolSubjectRepository;

    @Cacheable(cacheNames = "SchoolSubjects")
    public List<SchoolSubject> getSchoolSubjects(){
        return schoolSubjectRepository.findAll();
    }

    @Cacheable(cacheNames = "SchoolSubjectById")
    public SchoolSubject getSchoolSubjectById(long id){
        return schoolSubjectRepository.findSchoolSubjectById(id);
    }
    //test
    public SchoolSubject addSchoolSubject(SchoolSubject schoolSubject){
        return schoolSubjectRepository.save(schoolSubject);
    }

    public void deleteSchoolSubject(long id){
        schoolSubjectRepository.deleteById(id);
    }

}
