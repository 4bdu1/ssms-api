INSERT INTO students (created_at, modified_at, student_slugid, studentid, email_address, first_name, last_name)
VALUES
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'alex.doe@example.com', 'Alex', 'Doe'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'jane.smith@example.com', 'Jane', 'Smith'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'john.appleseed@example.com', 'John', 'Appleseed'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'lisa.ray@example.com', 'Lisa', 'Ray'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'mike.jordan@example.com', 'Mike', 'Jordan'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'sara.connor@example.com', 'Sara', 'Connor'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'tom.hanks@example.com', 'Tom', 'Hanks'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'emma.watson@example.com', 'Emma', 'Watson'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'daniel.craig@example.com', 'Daniel', 'Craig'),
    (now(), now(), gen_random_uuid(), gen_random_uuid(), 'olivia.colman@example.com', 'Olivia', 'Colman');
