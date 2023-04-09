package com.gl.ticketmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gl.ticketmgmt.entity.Ticket;

public interface iTicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {

}
