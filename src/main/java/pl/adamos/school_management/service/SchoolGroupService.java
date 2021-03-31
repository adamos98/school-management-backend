package pl.adamos.school_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adamos.school_management.model.SchoolGroup;
import pl.adamos.school_management.repository.SchoolGroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolGroupService {

    private final SchoolGroupRepository schoolGroupRepository;

    public List<SchoolGroup> getSchoolGroups(){
        return schoolGroupRepository.findAll();
    }

    public SchoolGroup getSchoolGroupById(long id){
        return schoolGroupRepository.findSchoolGroupById(id);
    }

    public SchoolGroup addSchoolGroup(SchoolGroup schoolGroup){
        return schoolGroupRepository.save(schoolGroup);
    }

    public void deleteSchoolGroup(long id){
        schoolGroupRepository.deleteById(id);
    }
}
