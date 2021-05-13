package com.proiect.catalog.converter;

import com.proiect.catalog.exception.MethodNotSupportedException;
import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.web.dto.TeacherBasicInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherBasicInfoConverter extends BaseConverter<TeacherBasicInfoDto, Teacher>{

    private final SubjectConverter subjectConverter;

    @Autowired
    public TeacherBasicInfoConverter(SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }

    @Override
    public TeacherBasicInfoDto fromEntityToDto(Teacher teacher) {
        TeacherBasicInfoDto dto = new TeacherBasicInfoDto();
        dto.setId(teacher.getId());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setSubjects(subjectConverter.fromEntitiesToDtos(teacher.getSubjects()));

        return dto;
    }

    @Override
    public Teacher fromDtoToEntity(TeacherBasicInfoDto dto) {
        throw new MethodNotSupportedException("Method not supported", "method.not.supported");
    }
}
