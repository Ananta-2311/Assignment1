package com.assignment.consultant.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ConsultantNotFoundException.class)
	public String handleConsultantNotFound(ConsultantNotFoundException ex, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", "The requested consultant could not be found.");
		return "redirect:/consultants";
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleInvalidId(MethodArgumentTypeMismatchException ex, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", "Invalid consultant ID. Please use a valid link from the consultant list.");
		return "redirect:/consultants";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String handleIllegalArgument(IllegalArgumentException ex, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMessage", "The request could not be completed. Please try again.");
		return "redirect:/consultants";
	}

	@ExceptionHandler(NoResourceFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFound(NoResourceFoundException ex, Model model) {
		model.addAttribute("pageTitle", "Page Not Found");
		model.addAttribute("errorTitle", "Page Not Found");
		model.addAttribute("errorMessage", "The page you are looking for does not exist.");
		return "error";
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleUnexpectedError(Exception ex, Model model) {
		log.error("Unexpected application error", ex);
		model.addAttribute("pageTitle", "Something Went Wrong");
		model.addAttribute("errorTitle", "Something Went Wrong");
		model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
		return "error";
	}
}
