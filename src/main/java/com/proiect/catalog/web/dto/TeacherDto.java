package com.proiect.catalog.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//used when we need to send all the Teacher related information (e.g.: if we need to display them from Teacher's user profile page
public class TeacherDto extends TeacherBasicInfoDto {

    @NotNull(message = "birthDate.cannot.be.empty")
    private LocalDate birthDate;
    @NotNull(message = "employmentDate.cannot.be.empty")
    private LocalDate employmentDate;
    @NotNull(message = "cnp.cannot.be.empty")
    @Size(min = 13, max = 13, message = "cnp.size.invalid")
    @Pattern(regexp = "[0-9]+", message = "cnp.invalid")
    private String cnp;
    @NotNull(message = "salary.cannot.be.empty")
    @Min(value = 1, message = "salary.cannot.be.negative")
    private Long salary;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherDto{");
        sb.append("birthDate=").append(birthDate);
        sb.append(", employmentDate=").append(employmentDate);
        sb.append(", cnp='").append(cnp).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
