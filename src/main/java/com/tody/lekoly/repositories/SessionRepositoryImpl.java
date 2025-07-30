package com.tody.lekoly.repositories;

import com.tody.lekoly.entities.Session;
import com.tody.lekoly.enums.SessionStatusEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class SessionRepositoryImpl implements SearchCriteriaRepository {
    private final EntityManager entityManager;


    public SessionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Session> findByCriteria(Date startDate, Date endDate, Long courseId, Long instructorId, String status) {

        String sql = "SELECT s FROM Session s WHERE 1 = 1 ";

        if(startDate != null ) {
            sql += " AND s.startDate = :startDate ";
        }

        if(endDate != null) {
            sql += " AND s.endDate = :endDate ";
        }

        if(courseId != null) {
            sql += " AND s.course.id = :courseId ";
        }

        if(instructorId != null) {
            sql += " AND s.instructor.id = :instructorId ";
        }

        if(status != null) {
            sql += " AND s.status = :status ";
        }


        TypedQuery<Session> query = this.entityManager.createQuery(sql, Session.class);

        if(startDate != null) {
            query.setParameter("startDate", startDate);
        }

        if(endDate != null) {
            query.setParameter("endDate", endDate);
        }

        if(courseId != null) {
            query.setParameter("courseId", courseId);
        }

        if(instructorId != null) {
            query.setParameter("instructorId", instructorId);
        }

        if(status != null) {
            query.setParameter("status", SessionStatusEnum.valueOf(status));
        }

        return query.getResultList();
    }
}
