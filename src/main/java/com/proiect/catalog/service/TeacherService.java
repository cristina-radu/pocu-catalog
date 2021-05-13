package com.proiect.catalog.service;

import com.proiect.catalog.exception.NotFoundException;
import com.proiect.catalog.model.Subject;
import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

@Service            //this annotation means that this class is a Bean
public class TeacherService {
    //service classes contain most of the business logic;

    private final SubjectService subjectService;
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(SubjectService subjectService, TeacherRepository teacherRepository) {
        this.subjectService = subjectService;
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);

        return teachers;
    }

    public List<Teacher> getAllTeachersByCnp(String cnp) {
        Optional<Teacher> byCnp = teacherRepository.findByCnp(cnp);
        return byCnp
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }

    public List<Teacher> getAllTeachersByName(String firstName, String lastName) {
        return teacherRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Teacher getTeacher(Long id) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }
    }

    public Teacher assignSubjectToTeacher(Long teacherId, Long subjectId) {
        Subject subject = subjectService.getSubject(subjectId);
        Teacher teacher = getTeacher(teacherId);

        teacher.setSubject(subject);
        return teacherRepository.save(teacher);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()) {
            teacher.setId(id);
            teacher.setSubjects(byId.get().getSubjects());
            return teacherRepository.save(teacher);
        } else {
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }
    }

    public void deleteTeacher(Long id) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()) {
            teacherRepository.deleteById(id);
        } else {
            throw new NotFoundException("Teacher not found", "teacher.not.found");
        }
    }

    public List<Teacher> getAllTeachers(Integer page, Integer size) {
        //find all using pagination; it retrieves page number 'page' if we split the result in chunks of 'size' length
        //page number starts from 0
        PageRequest pageRequest = PageRequest.of(page, size);
        return teacherRepository.findAll(pageRequest).getContent();
    }
}
