package com.proiect.catalog.web.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

//Contains only basic teacher related info (e.g.: to be used for Student's page - we don't need all the info there, just the basic info such as first name, last name
public class TeacherBasicInfoDto extends BaseDto {

    private Long id;
    @NotNull(message = "firstName.cannot.be.empty")
    private String firstName;
    @NotNull(message = "lastName.cannot.be.empty")
    private String lastName;
    private List<SubjectDto> subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherBasicInfoDto{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", subjects=").append(subjects);
        sb.append('}');
        return sb.toString();
    }
}
