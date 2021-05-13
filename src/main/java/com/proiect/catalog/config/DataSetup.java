package com.proiect.catalog.config;

import com.proiect.catalog.model.Subject;
import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.repository.SubjectRepository;
import com.proiect.catalog.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ConditionalOnExpression("${insert.test.data}")
public class DataSetup implements ApplicationRunner {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

/*    @Value("${insert.test.data}")
    private Boolean insertTestData;*/

    @Autowired
    public DataSetup(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       // if (insertTestData) {
            saveSubject("Matematica", 20, 80, 5, true);
            saveSubject("Fizica", 30, 70, 5, false);
            saveSubject("Informatica", 50, 50, 5, false);
            saveSubject("Chimie", 20, 80, 5, true);
            saveSubject("Biologie", 20, 80, 5, true);

            saveTeacher("Ion", "Popescu", "2920101445561", 100L);
            saveTeacher("Aurelian", "Radu", "2920101445562", 170L);
            saveTeacher("George", "Temisan", "2920101445563", 160L);
            saveTeacher("Laurentiu", "Branescu", "2920101445564", 150L);
            saveTeacher("Ana-Maria", "Popescu", "2920101445565", 140L);
       // }
    }

    private void saveSubject(String subjectName, Integer coursePercent, Integer seminaryPercent,
                                Integer creditPoints, Boolean isOptional) {
        Subject subject = new Subject();
        subject.setName(subjectName);
        subject.setCoursePercent(coursePercent);
        subject.setSeminaryPercent(seminaryPercent);
        subject.setCreditPoints(creditPoints);
        subject.setOptional(isOptional);

        subjectRepository.save(subject);
    }

    private void saveTeacher(String firstName, String lastName, String cnp, Long salary) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setCnp(cnp);
        teacher.setSalary(salary);
        teacher.setEmploymentDate(LocalDate.now());
        teacher.setBirthDate(LocalDate.now());

        teacherRepository.save(teacher);
    }
}
