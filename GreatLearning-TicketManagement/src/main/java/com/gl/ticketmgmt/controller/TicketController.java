package com.gl.ticketmgmt.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ticketmgmt.entity.Ticket;
import com.gl.ticketmgmt.service.iTicketService;

@Controller
public class TicketController {

	iTicketService tcktService;

	public TicketController(iTicketService tcktService) {
		this.tcktService = tcktService;
	}

	@GetMapping("/")
	public String showroot(Model model) {
		model.addAttribute("date", new Date());
		return "home";
	}

	@GetMapping("/home")
	public String showHome(Model model) {
		model.addAttribute("date", new Date());
		return "home";
	}

	@GetMapping("/tickets")
	public String showEmpList(Model model) {
		model.addAttribute("tickets", tcktService.getAllTickets());
		return "ListTicket";

	}

	@RequestMapping(value = "/tickets/search", method = RequestMethod.GET)
	public String messages(@RequestParam("query") String searchString, Model model) {

		model.addAttribute("tickets", tcktService.searchTickets(searchString));
		return "ListTicket";
	}

	@GetMapping("/newTicket")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("tckt", ticket);
		return "CreateTicket";
	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("tckt") Ticket ticket) {
		tcktService.saveTicket(ticket);
		return "redirect:/tickets";

	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {
		tcktService.deleteTicket(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicket(@PathVariable Long id, Model model) {
		Ticket ticket;
		ticket = tcktService.viewTicket(id);
		model.addAttribute("tckt", ticket);
		return "ViewTicket";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicket(@PathVariable Long id, Model model) {

		model.addAttribute("tckt", tcktService.viewTicket(id));
		return "EditTicket";
	}

	@PostMapping("/tickets/update/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		Ticket existingTicket = tcktService.viewTicket(id);

		existingTicket.setTcktTitle(ticket.getTcktTitle());
		existingTicket.setTcktDescription(ticket.getTcktDescription());
		existingTicket.setTcktContent(ticket.getTcktContent());

		tcktService.updateTicket(existingTicket);

		model.addAttribute("tckt", ticket);
		return "redirect:/tickets";
	}

}
