package com.assignment.consultant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "consultants")
public class Consultant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(max = 100, message = "Name must be at most 100 characters")
	@Column(nullable = false, length = 100)
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email must be a valid email address")
	@Size(max = 150, message = "Email must be at most 150 characters")
	@Column(nullable = false, length = 150)
	private String email;

	@NotBlank(message = "Phone is required")
	@Size(max = 20, message = "Phone must be at most 20 characters")
	@Column(nullable = false, length = 20)
	private String phone;

	@NotBlank(message = "Technology is required")
	@Size(max = 100, message = "Technology must be at most 100 characters")
	@Column(nullable = false, length = 100)
	private String technology;

	@NotNull(message = "Experience is required")
	@Min(value = 0, message = "Experience must be 0 or greater")
	@Column(nullable = false)
	private Integer experience;

	public Consultant() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
}
