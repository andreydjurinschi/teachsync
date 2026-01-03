-- liquibase formatted sql
-- changeset andrei:insert-10-users
INSERT INTO users (name, surname, email, password, registered_at, role) VALUES
('Andrei', 'Djurinschi', 'alice.smith@example.com', 'hashed_pwd1', '2026-01-01', 'ADMIN'),
('Bob', 'Johnson', 'bob.johnson@example.com', 'hashed_pwd2', '2026-01-01', 'TEACHER'),
('Carol', 'Williams', 'carol.williams@example.com', 'hashed_pwd3', '2026-01-01', 'MANAGER'),
('David', 'Brown', 'david.brown@example.com', 'hashed_pwd4', '2026-01-01', 'TEACHER'),
('Eve', 'Jones', 'eve.jones@example.com', 'hashed_pwd5', '2026-01-01', 'MANAGER'),
('Frank', 'Garcia', 'frank.garcia@example.com', 'hashed_pwd6', '2026-01-01', 'TEACHER'),
('Grace', 'Miller', 'grace.miller@example.com', 'hashed_pwd7', '2026-01-01', 'TEACHER'),
('Hank', 'Davis', 'hank.davis@example.com', 'hashed_pwd8', '2026-01-01', 'TEACHER'),
('Ivy', 'Martinez', 'ivy.martinez@example.com', 'hashed_pwd9', '2026-01-01', 'TEACHER'),
('Jack', 'Lopez', 'jack.lopez@example.com', 'hashed_pwd10', '2026-01-01', 'TEACHER');
