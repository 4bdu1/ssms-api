drop table if exists students cascade;

create table students (
      created_at timestamp(6) with time zone,
      modified_at timestamp(6) with time zone,
      student_slugid uuid,
      studentid uuid not null,
      email_address varchar(255) not null unique,
      first_name varchar(255),
      last_name varchar(255),
      primary key (studentid)
);