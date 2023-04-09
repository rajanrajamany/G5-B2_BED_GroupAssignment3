package com.gl.ticketmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ticketmgmt.entity.Ticket;

@Service
public interface iTicketService {

	public List<Ticket> getAllTickets();

	public Ticket updateTicket(Ticket ticket);

	public Ticket saveTicket(Ticket ticket);

	public void deleteTicket(Long id);

	public List<Ticket> searchTickets(String searchString);

	public Ticket viewTicket(Long id);

}
