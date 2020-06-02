package com.ranjan.airline.service;

import java.util.List;

import org.springframework.http.HttpHeaders;

import com.ranjan.airline.config.AirlineRuntimeException;
import com.ranjan.airline.model.PassangerBean;
import com.ranjan.airline.model.SearchBean;

public interface AirlineService {

	public List<SearchBean> getSearchResult(String departForm, String goingTo, String date, HttpHeaders httpHeaders)
			throws AirlineRuntimeException;

	public PassangerBean savePassanger(PassangerBean passengers, HttpHeaders httpHeaders) throws AirlineRuntimeException;

}
