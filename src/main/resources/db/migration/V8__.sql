ALTER TABLE instructor
    ALTER COLUMN description TYPE TEXT USING (description::TEXT);