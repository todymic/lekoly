package com.tody.lekoly.repositories;

import com.tody.lekoly.entities.Session;

import java.util.Date;
import java.util.List;

public interface SearchCriteriaRepository {
    List<Session> findByCriteria(
            Date startDate,
            Date endDate,
            Long courseId,
            Long instructorId,
            String status
    );
}
