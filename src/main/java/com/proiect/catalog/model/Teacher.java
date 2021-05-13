package com.proiect.catalog.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cnp")
    private String cnp;

    @Column(name = "employment_date")
    private LocalDate employmentDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "salary")        //won't be sent into dto
    private Long salary;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Subject> subjects;


    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setSubject(Subject subject) {
        if (this.subjects == null) {
            this.subjects = new ArrayList<>();
        }
        this.subjects.add(subject);
    }


    @Override
    public String toString() {
        return  "Teacher{" + "id='" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", employmentDate=" + employmentDate +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", subjects=" + subjects +
                '}';
    }
}
