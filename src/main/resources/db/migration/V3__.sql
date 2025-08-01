ALTER TABLE course_session
    RENAME TO section;

ALTER TABLE course
    ALTER COLUMN price TYPE DECIMAL(10, 2) USING (price::DECIMAL(10, 2));