package com.tody.lekoly.repositories;

import com.tody.lekoly.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>, SearchCriteriaRepository {
}