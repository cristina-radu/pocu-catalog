package com.proiect.catalog.web;            // controllers containing endpoints

import com.proiect.catalog.converter.SubjectConverter;
import com.proiect.catalog.model.Subject;
import com.proiect.catalog.service.SubjectService;
import com.proiect.catalog.web.dto.SubjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost", "http://localhost:4200"})
@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    private Logger logger = LoggerFactory.getLogger(SubjectController.class);


    private final SubjectService subjectService;
    private final SubjectConverter subjectConverter;

    @Autowired
    public SubjectController(SubjectService subjectService, SubjectConverter subjectConverter) {
        this.subjectService = subjectService;
        this.subjectConverter = subjectConverter;
    }

    @GetMapping(value = "", produces = "application/json")
    public List<SubjectDto> getSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();

        return subjectConverter.fromEntitiesToDtos(subjects);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SubjectDto getSubject(@PathVariable Long id) {  //in order to take variables from URL we can use @PathVariable
        Subject subject = subjectService.getSubject(id); //subjectService.getSubject(id)  Alt + Enter ==> Subject subject = subjectService.getSubject(id)

        return subjectConverter.fromEntityToDto(subject);
    }

    @PostMapping(value = "", produces = "application/json")
    public SubjectDto saveNewSubject(@Valid @RequestBody SubjectDto request) {
        Subject subjectToBeSaved = subjectConverter.fromDtoToEntity(request);
        Subject savedSubject = subjectService.saveSubject(subjectToBeSaved);

        logger.info("Saved new subject {}", savedSubject);
        return subjectConverter.fromEntityToDto(savedSubject);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public SubjectDto updateSubject(@PathVariable Long id, @Valid @RequestBody  SubjectDto request) {
        Subject subject = subjectConverter.fromDtoToEntity(request);
        subject = subjectService.updateSubject(subject, id);

        return subjectConverter.fromEntityToDto(subject);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }


}
