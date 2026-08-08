-- Consultant Management System
-- Creates the database and consultants table to match the Consultant entity

CREATE DATABASE IF NOT EXISTS consultant_management
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE consultant_management;

CREATE TABLE IF NOT EXISTS consultants (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  technology VARCHAR(100) NOT NULL,
  experience INT NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci;

-- Sample data for local development (Nepali names)
DELETE FROM consultants;

INSERT INTO consultants (name, email, phone, technology, experience) VALUES
('Ananta Aryal', 'ananta.aryal@example.com', '9841001001', 'Java', 5),
('Sita Sharma', 'sita.sharma@example.com', '9841001002', 'Python', 3),
('Bibek Thapa', 'bibek.thapa@example.com', '9841001003', 'React', 4),
('Prisha Adhikari', 'prisha.adhikari@example.com', '9841001004', 'Spring Boot', 7),
('Kiran Gurung', 'kiran.gurung@example.com', '9841001005', 'MySQL', 2),
('Nisha Karki', 'nisha.karki@example.com', '9841001006', 'Angular', 6),
('Roshan Bhandari', 'roshan.bhandari@example.com', '9841001007', 'Node.js', 4),
('Aasha Magar', 'aasha.magar@example.com', '9841001008', 'Docker', 3),
('Sagar Poudel', 'sagar.poudel@example.com', '9841001009', 'AWS', 8),
('Manisha Rai', 'manisha.rai@example.com', '9841001010', 'Flutter', 5);
