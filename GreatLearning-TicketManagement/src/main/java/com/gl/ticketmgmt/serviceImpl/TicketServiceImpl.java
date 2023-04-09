package com.gl.ticketmgmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gl.ticketmgmt.entity.Ticket;
import com.gl.ticketmgmt.repository.iTicketRepository;
import com.gl.ticketmgmt.service.SearchCriteria;
import com.gl.ticketmgmt.service.TicketSpecification;
import com.gl.ticketmgmt.service.iTicketService;

@Service
public class TicketServiceImpl implements iTicketService {

	@Autowired
	iTicketRepository tcktRepository;

	public TicketServiceImpl(iTicketRepository tcktRepository) {
		super();
		this.tcktRepository = tcktRepository;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return tcktRepository.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub

		return tcktRepository.save(ticket);
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return tcktRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		tcktRepository.deleteById(id);
	}

	@Override
	public List<Ticket> searchTickets(String searchString) {
		// TODO Auto-generated method stub

		TicketSpecification spec1 = new TicketSpecification(new SearchCriteria("tcktTitle", ":", searchString));

		TicketSpecification spec2 = new TicketSpecification(new SearchCriteria("tcktDescription", ":", searchString));

		return tcktRepository.findAll(Specification.where(spec1).or(spec2));

	}

	@Override
	public Ticket viewTicket(Long id) {
		// TODO Auto-generated method stub
		return tcktRepository.findById(id).get();
	}

}
