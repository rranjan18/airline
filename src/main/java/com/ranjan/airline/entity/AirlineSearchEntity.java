package com.ranjan.airline.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RANJAN_AIRLINE_SEARCH")
public class AirlineSearchEntity {

	@Id
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@GeneratedValue(generator = "generator")
	@Column(name = "UID")
	private String id;
	@Column(name = "SORT_BY")
	private String sortBy;
	@Column(name = "DEPART")
	private String depart;
	@Column(name = "ARRIVE")
	private String arrive;
	@Column(name = "DURATION")
	private String duration;
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "DEPART_FORM")
	private String departForm;
	@Column(name = "GOING_TO")
	private String goingTo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDepartForm() {
		return departForm;
	}

	public void setDepartForm(String departForm) {
		this.departForm = departForm;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

}
