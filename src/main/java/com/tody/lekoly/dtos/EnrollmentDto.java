package com.tody.lekoly.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link com.tody.lekoly.entities.Enrollment}
 */
public class EnrollmentDto implements Serializable {
    private final Long id;
    private final String status;
    private final Date enrollmentDate;
    private final SessionDto session;

    public EnrollmentDto(Long id, String status, Date enrollmentDate, SessionDto session) {
        this.id = id;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
        this.session = session;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public SessionDto getSession() {
        return session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentDto entity = (EnrollmentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.enrollmentDate, entity.enrollmentDate) &&
                Objects.equals(this.session, entity.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, enrollmentDate, session);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "status = " + status + ", " +
                "enrollmentDate = " + enrollmentDate + ", " +
                "session = " + session + ")";
    }
}