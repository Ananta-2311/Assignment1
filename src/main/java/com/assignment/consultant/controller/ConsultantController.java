package com.assignment.consultant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assignment.consultant.model.Consultant;
import com.assignment.consultant.service.ConsultantService;

import jakarta.validation.Valid;

@Controller
public class ConsultantController {

	private final ConsultantService consultantService;

	public ConsultantController(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("totalConsultants", consultantService.getTotalConsultantCount());
		model.addAttribute("consultants", consultantService.getAllConsultants());
		return "dashboard";
	}

	@GetMapping("/consultants")
	public String listConsultants(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		return showConsultantList(keyword, model);
	}

	@GetMapping("/consultants/search")
	public String searchConsultants(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		return showConsultantList(keyword, model);
	}

	@GetMapping("/consultants/add")
	public String showAddForm(Model model) {
		model.addAttribute("consultant", new Consultant());
		model.addAttribute("pageTitle", "Add Consultant");
		model.addAttribute("formAction", "/consultants/add");
		return "consultant-form";
	}

	@PostMapping("/consultants/add")
	public String addConsultant(@Valid @ModelAttribute("consultant") Consultant consultant, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pageTitle", "Add Consultant");
			model.addAttribute("formAction", "/consultants/add");
			model.addAttribute("errorMessage", "Please correct the highlighted fields and try again.");
			return "consultant-form";
		}

		consultantService.addConsultant(consultant);
		redirectAttributes.addFlashAttribute("successMessage", "Consultant added successfully.");
		return "redirect:/consultants";
	}

	@GetMapping("/consultants/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("consultant", consultantService.getConsultantById(id));
		model.addAttribute("pageTitle", "Edit Consultant");
		model.addAttribute("formAction", "/consultants/edit/" + id);
		return "consultant-form";
	}

	@PostMapping("/consultants/edit/{id}")
	public String updateConsultant(@PathVariable Long id, @Valid @ModelAttribute("consultant") Consultant consultant,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pageTitle", "Edit Consultant");
			model.addAttribute("formAction", "/consultants/edit/" + id);
			model.addAttribute("errorMessage", "Please correct the highlighted fields and try again.");
			return "consultant-form";
		}

		consultantService.updateConsultant(id, consultant);
		redirectAttributes.addFlashAttribute("successMessage", "Consultant updated successfully.");
		return "redirect:/consultants";
	}

	@GetMapping("/consultants/delete/{id}")
	public String deleteConsultant(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		consultantService.deleteConsultant(id);
		redirectAttributes.addFlashAttribute("successMessage", "Consultant deleted successfully.");
		return "redirect:/consultants";
	}

	private String showConsultantList(String keyword, Model model) {
		List<Consultant> consultants = consultantService.searchConsultants(keyword);
		boolean searching = keyword != null && !keyword.isBlank();

		model.addAttribute("consultants", consultants);
		model.addAttribute("keyword", searching ? keyword.trim() : "");
		model.addAttribute("searching", searching);
		model.addAttribute("resultCount", consultants.size());
		return "consultants";
	}
}
