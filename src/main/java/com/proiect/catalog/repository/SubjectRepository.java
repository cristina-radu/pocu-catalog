package com.proiect.catalog.repository; //repository interfaces - help us execute SQL queries

import com.proiect.catalog.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    void deleteByName(String name);

    Long countByCreditPointsBetween(Integer creditPointsMin, Integer creditPointsMax);

}
