package com.proiect.catalog.web;

import com.proiect.catalog.converter.TeacherBasicInfoConverter;
import com.proiect.catalog.converter.TeacherConverter;
import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.service.TeacherService;
import com.proiect.catalog.web.dto.TeacherBasicInfoDto;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost", "http://localhost:4200"})
@RestController         //this annotation means that this class will be a Bean (managed by spring) and will contain endpoints (an endpoint is a method that handles HTTP requests end returns a HTTP response)
@RequestMapping(value = "/teacher")     //base of the URLs of the endpoints from this class
public class TeacherController {

    //the controllers usually shouldn't have much logic in them
    //they should call services to retrieve needed data, perform validations
    //most of the logic should be in the services


    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    private final TeacherBasicInfoConverter teacherBasicInfoConverter;

    @Autowired  //injects (an instance) of TeacherService in the controller
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter,
                             TeacherBasicInfoConverter teacherBasicInfoConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
        this.teacherBasicInfoConverter = teacherBasicInfoConverter;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public TeacherDto getTeacher(@PathVariable(name = "id") Long id) {
        Teacher teacher = teacherService.getTeacher(id);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @GetMapping(value = "/{id}/basic", produces = "application/json")
    public TeacherBasicInfoDto getTeacherBasicInfo(@PathVariable(name = "id") Long id) {
        Teacher teacher = teacherService.getTeacher(id);

        return teacherBasicInfoConverter.fromEntityToDto(teacher);
    }

    @GetMapping(value = "", produces = "application/json")
    public List<TeacherDto> getAll(@RequestParam(name = "cnp", required = false) String cnp,
                                   @RequestParam(name = "firstName", required = false) String firstName,
                                   @RequestParam(name = "lastName", required = false) String lastName) {
        List<Teacher> allTeachers;
        if (cnp != null) {
            allTeachers = teacherService.getAllTeachersByCnp(cnp);
        }  else if (firstName != null && lastName != null) {
            allTeachers = teacherService.getAllTeachersByName(firstName, lastName);
        } else {
            allTeachers = teacherService.getAllTeachers();
        }

        return teacherConverter.fromEntitiesToDtos(allTeachers);
    }

    @GetMapping(value = "/basic", produces = "application/json")
    public List<TeacherBasicInfoDto> getAllBasicInfo(@RequestParam(name = "page", required = false) Integer page,
                                                     @RequestParam(name = "size", required = false) Integer size) {
        //find with pagination
        List<Teacher> allTeachers;

        if (page != null && size != null) {
            allTeachers = teacherService.getAllTeachers(page, size);
        } else {
            allTeachers = teacherService.getAllTeachers();
        }

        return teacherBasicInfoConverter.fromEntitiesToDtos(allTeachers);
    }

    @PostMapping(value = "", produces = "application/json")
    public TeacherDto saveTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        Teacher teacher = teacherConverter.fromDtoToEntity(teacherDto);
        teacher = teacherService.saveTeacher(teacher);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public TeacherDto updateTeacher(@PathVariable(name = "id") Long id,
                                    @Valid @RequestBody TeacherDto teacherDto) {
        Teacher teacher = teacherConverter.fromDtoToEntity(teacherDto);
        teacher = teacherService.updateTeacher(id, teacher);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @PutMapping(value = "/{teacherId}/subject/{subjectId}", produces = "application/json")
    public TeacherDto assignSubjectToTeacher(@PathVariable(name = "teacherId") Long teacherId,
                                             @PathVariable(name= "subjectId") Long subjectId) {

        Teacher teacher = teacherService.assignSubjectToTeacher(teacherId, subjectId);

        return teacherConverter.fromEntityToDto(teacher);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteTeacher(@PathVariable(name = "id") Long id){
        teacherService.deleteTeacher(id);
    }

}
