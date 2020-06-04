package com.ranjan.airline;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import com.ranjan.airline.config.JwtTokenUtil;
import com.ranjan.airline.model.SearchBean;

@RunWith(MockitoJUnitRunner.class)
public class JWTutillTest {

	@Mock
	private JwtTokenUtil jwtTokentUtl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSearchResult() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "bearer -dfdfasfdsafdsfllerefdsfasfdasdfsdfdsryhbdgaagfdvdfgvdrfgr");

		jwtTokentUtl.validateToken(httpHeaders);

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
