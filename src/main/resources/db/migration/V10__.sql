ALTER TABLE video_progress
    ADD last_viewed_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE video_progress
    ADD watched_duration INTEGER;

ALTER TABLE video_progress
    DROP COLUMN last_time_visualized;