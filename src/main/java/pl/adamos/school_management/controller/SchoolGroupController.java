package pl.adamos.school_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adamos.school_management.model.SchoolGroup;
import pl.adamos.school_management.service.SchoolGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolGroupController {

    private final SchoolGroupService schoolGroupService;

    @GetMapping("/schoolgroups")
    public List<SchoolGroup> getSchoolGroups(){
        return schoolGroupService.getSchoolGroups();
    }

    @GetMapping("/schoolgroups/{id}")
    public SchoolGroup getSchoolGroupById(@PathVariable long id){
        return schoolGroupService.getSchoolGroupById(id);
    }

    @PostMapping("/schoolgroups")
    public SchoolGroup addSchoolGroup(@RequestBody SchoolGroup schoolGroup){
        return schoolGroupService.addSchoolGroup(schoolGroup);
    }

    @DeleteMapping("/schoolgroups/{id}")
    public void deleteSchoolGroup(@PathVariable long id){
        schoolGroupService.deleteSchoolGroup(id);
    }

}
