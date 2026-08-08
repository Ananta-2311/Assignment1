package com.assignment.consultant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.consultant.exception.ConsultantNotFoundException;
import com.assignment.consultant.model.Consultant;
import com.assignment.consultant.repository.ConsultantRepository;

@Service
@Transactional
public class ConsultantService {

	private final ConsultantRepository consultantRepository;

	public ConsultantService(ConsultantRepository consultantRepository) {
		this.consultantRepository = consultantRepository;
	}

	@Transactional(readOnly = true)
	public List<Consultant> getAllConsultants() {
		return consultantRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Consultant getConsultantById(Long id) {
		return consultantRepository.findById(id)
				.orElseThrow(() -> new ConsultantNotFoundException("Consultant not found"));
	}

	public Consultant addConsultant(Consultant consultant) {
		consultant.setId(null);
		return consultantRepository.save(consultant);
	}

	public Consultant updateConsultant(Long id, Consultant consultantDetails) {
		Consultant existing = getConsultantById(id);

		existing.setName(consultantDetails.getName());
		existing.setEmail(consultantDetails.getEmail());
		existing.setPhone(consultantDetails.getPhone());
		existing.setTechnology(consultantDetails.getTechnology());
		existing.setExperience(consultantDetails.getExperience());

		return consultantRepository.save(existing);
	}

	public void deleteConsultant(Long id) {
		if (!consultantRepository.existsById(id)) {
			throw new ConsultantNotFoundException("Consultant not found");
		}
		consultantRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Consultant> searchConsultants(String keyword) {
		if (keyword == null || keyword.isBlank()) {
			return getAllConsultants();
		}

		String searchTerm = keyword.trim();
		return consultantRepository.findByNameContainingIgnoreCaseOrTechnologyContainingIgnoreCase(searchTerm,
				searchTerm);
	}

	@Transactional(readOnly = true)
	public long getTotalConsultantCount() {
		return consultantRepository.count();
	}
}
