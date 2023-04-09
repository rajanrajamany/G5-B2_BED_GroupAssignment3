package com.gl.ticketmgmt.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tcktTitle;
	private String tcktDescription;

	@Column(columnDefinition = "TEXT")
	private String tcktContent;

	@CreatedDate
	private Date tcktCreatedOn = new Date();

	public Ticket() {

		// TODO Auto-generated constructor stub
	}

	public Ticket(long id, String tcktTitle, String tcktDescription, String tcktContent, Date tcktCreatedOn) {

		this.id = id;
		this.tcktTitle = tcktTitle;
		this.tcktDescription = tcktDescription;
		this.tcktContent = tcktContent;
		this.tcktCreatedOn = tcktCreatedOn;
	}

	public long getId() {
		return id;
	}

	public String getTcktTitle() {
		return tcktTitle;
	}

	public void setTcktTitle(String tcktTitle) {
		this.tcktTitle = tcktTitle;
	}

	public String getTcktDescription() {
		return tcktDescription;
	}

	public void setTcktDescription(String tcktDescription) {
		this.tcktDescription = tcktDescription;
	}

	public String getTcktContent() {
		return tcktContent;
	}

	public void setTcktContent(String tcktContent) {
		this.tcktContent = tcktContent;
	}

	public Date getTcktCreatedOn() {
		return tcktCreatedOn;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", tcktTitle=" + tcktTitle + ", tcktDescription=" + tcktDescription
				+ ", tcktContent=" + tcktContent + ", tcktCreatedOn=" + tcktCreatedOn + "]";
	}

}
