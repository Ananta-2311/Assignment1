package com.assignment.consultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.consultant.model.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
}
