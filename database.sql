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
