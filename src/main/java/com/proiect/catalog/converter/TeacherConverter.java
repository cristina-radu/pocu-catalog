package com.proiect.catalog.converter;

import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter extends BaseConverter<TeacherDto, Teacher> {

    private final SubjectConverter subjectConverter;

    @Autowired
    public TeacherConverter(SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }

    @Override
    public TeacherDto fromEntityToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setEmploymentDate(teacher.getEmploymentDate());
        teacherDto.setBirthDate(teacher.getBirthDate());
        teacherDto.setCnp(teacher.getCnp());
        teacherDto.setSalary(teacher.getSalary());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setSubjects(subjectConverter.fromEntitiesToDtos(teacher.getSubjects()));

        return teacherDto;
    }

    @Override
    public Teacher fromDtoToEntity(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setBirthDate(dto.getBirthDate());
        teacher.setEmploymentDate(dto.getEmploymentDate());
        teacher.setCnp(dto.getCnp());
        teacher.setSalary(dto.getSalary());

        return teacher;
    }
}
