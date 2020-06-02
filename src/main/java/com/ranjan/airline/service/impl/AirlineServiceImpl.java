package com.ranjan.airline.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ranjan.airline.config.AirlineRuntimeException;
import com.ranjan.airline.config.JwtTokenUtil;
import com.ranjan.airline.model.PassangerBean;
import com.ranjan.airline.model.SearchBean;
import com.ranjan.airline.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {

	// @Autowired
	// private AirlineRepository airlineRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public List<SearchBean> getSearchResult(String departForm, String goingTo, String date, HttpHeaders httpHeaders)
			throws AirlineRuntimeException {

		jwtTokenUtil.validateToken(httpHeaders);

		List<SearchBean> searchList = getDummyResponse();
		return searchList;
	}

	public PassangerBean savePassanger(PassangerBean passengers, HttpHeaders httpHeaders) throws AirlineRuntimeException {
		jwtTokenUtil.validateToken(httpHeaders);

		passengers.setId(UUID.randomUUID().toString());
		return passengers;

	}

	private List<SearchBean> getDummyResponse() {
		List<SearchBean> searchList = new ArrayList<>();
		SearchBean searchBean = new SearchBean();

		searchBean.setId(UUID.randomUUID().toString());
		searchBean.setSortBy("Go-AIR");
		searchBean.setDepart("06:10");
		searchBean.setArrive("9:10");
		searchBean.setDuration("03:00");
		searchBean.setAmount(new BigDecimal("4500"));

		SearchBean searchBean1 = new SearchBean();

		searchBean1.setId(UUID.randomUUID().toString());
		searchBean1.setSortBy("Jet-Airways");
		searchBean1.setDepart("16:25");
		searchBean1.setArrive("19:35");
		searchBean1.setDuration("03:10");
		searchBean1.setAmount(new BigDecimal("6500"));

		searchList.add(searchBean);
		searchList.add(searchBean1);
		return searchList;
	}

}
