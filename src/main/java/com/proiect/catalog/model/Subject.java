package com.proiect.catalog.model;  //package containing all the entities (classes that are mapped to the db tables)
                                    // for each model (table) you usually have: 1 model, 1 repository, 1 service, 1 controller, 1 dto
import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "credit_points")
    private Integer creditPoints;

    @Column(name = "is_optional")
    private Boolean isOptional;

    @Column(name = "course_percent")
    private Integer coursePercent;

    @Column(name = "seminary_percent")
    private Integer seminaryPercent;

    //getters and setters & toString() - Alt + Insert for IntelliJ auto-generation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(Integer creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Boolean getOptional() {
        return isOptional;
    }

    public void setOptional(Boolean optional) {
        isOptional = optional;
    }

    public Integer getCoursePercent() {
        return coursePercent;
    }

    public void setCoursePercent(Integer coursePercent) {
        this.coursePercent = coursePercent;
    }

    public Integer getSeminaryPercent() {
        return seminaryPercent;
    }

    public void setSeminaryPercent(Integer seminaryPercent) {
        this.seminaryPercent = seminaryPercent;
    }

    @Override
    public String toString() {
        return  "Subject{" + "id=" + getId() +
                ", name='" + name + '\'' +
                ", creditPoints=" + creditPoints +
                ", isOptional=" + isOptional +
                ", coursePercent=" + coursePercent +
                ", seminaryPercent=" + seminaryPercent +
                '}';
    }
}
