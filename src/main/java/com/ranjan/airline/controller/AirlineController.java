package com.ranjan.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranjan.airline.model.PassangerBean;
import com.ranjan.airline.model.SearchBean;
import com.ranjan.airline.service.AirlineService;

@RestController
@RequestMapping("/core")
public class AirlineController {

	@Autowired
	private AirlineService service;

	@GetMapping(value = "/search", produces = "application/json")
	public HttpEntity<List<SearchBean>> getSearchResult(@RequestHeader HttpHeaders httpHeaders,
			@RequestParam String departForm, @RequestParam String goingTo, @RequestParam String date) {

		return new ResponseEntity<>(service.getSearchResult(departForm, goingTo, date, httpHeaders), HttpStatus.OK);
	}

	@RequestMapping(value = "/savePassenger", method = RequestMethod.POST)
	public HttpEntity<PassangerBean> passanger(@RequestHeader HttpHeaders httpHeaders,
			@RequestBody PassangerBean passengers) {

		return new ResponseEntity<>(service.savePassanger(passengers, httpHeaders), HttpStatus.OK);
	}
}
