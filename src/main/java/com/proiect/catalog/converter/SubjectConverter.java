package com.proiect.catalog.converter;

import com.proiect.catalog.model.Subject;
import com.proiect.catalog.web.dto.SubjectDto;
import com.proiect.catalog.web.dto.SubjectScoringDto;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter extends BaseConverter<SubjectDto, Subject> {

    @Override
    public SubjectDto fromEntityToDto(Subject entity) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(entity.getId());
        subjectDto.setName(entity.getName());
        subjectDto.setOptional(entity.getOptional());
        subjectDto.setCreditPoints(entity.getCreditPoints());
        subjectDto.setSubjectScoring(new SubjectScoringDto(entity.getCoursePercent(),
                entity.getSeminaryPercent()));

        return subjectDto;
    }

    @Override
    public Subject fromDtoToEntity(SubjectDto dto) {
        Subject entity = new Subject();
        entity.setName(dto.getName());
        entity.setCreditPoints(dto.getCreditPoints());
        entity.setOptional(dto.getOptional());
        entity.setCoursePercent(dto.getSubjectScoring().getCoursePercent());
        entity.setSeminaryPercent(dto.getSubjectScoring().getSeminaryPercent());

        return entity;
    }
}
