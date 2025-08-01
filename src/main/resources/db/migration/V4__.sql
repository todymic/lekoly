ALTER TABLE section
    DROP CONSTRAINT fk_course_session_on_video;

ALTER TABLE video
    ADD order_index INTEGER;

ALTER TABLE video
    ADD section_id BIGINT;

ALTER TABLE video
    ALTER COLUMN section_id SET NOT NULL;

ALTER TABLE video
    ADD CONSTRAINT FK_VIDEO_ON_SECTION FOREIGN KEY (section_id) REFERENCES section (id);

ALTER TABLE section
    DROP COLUMN video_id;