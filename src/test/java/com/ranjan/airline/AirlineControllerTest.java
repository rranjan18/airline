package com.ranjan.airline;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranjan.airline.model.SearchBean;

//@SpringBootTest
@RunWith(SpringRunner.class)
public class AirlineControllerTest {

	private RestTemplate restTemplate;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper mapper;

	// @MockBean
	// private SearchTypeEntityRepository SearchTypeEntityRepository;

	private static final String BASE_URL = "/core/search";

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() throws Exception {

		// List<SearchTypeEntity> SearchTypeEntity =
		// buildSearchTypeEntity();

		// BDDMockito.given(this.SearchTypeEntityRepository.findAll()).willReturn(SearchTypeEntity);
		MvcResult result = this.mockMvc.perform(get(BASE_URL)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andReturn();

		List<SearchBean> searchBeanList = mapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<List<SearchBean>>() {
				});
		assertEquals(searchBeanList.size(), 2);

		SearchBean SearchBean = searchBeanList.get(0);
		assertEquals("Go-AIR", SearchBean.getSortBy());
		assertEquals("4500", SearchBean.getAmount());

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetWishlistsSuccess() throws URISyntaxException {

		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.add("Authorization",
		// "bearer " +
		// "fasdfafafaffdfdfdfdfdfdf-dfdfasfdsafdsfllerefdsfasfdasdfsdfdsryhbdgaagfdvdfgvdrfgr");
		//
		// HttpEntity<?> request = new HttpEntity<>(headers);

		final String baseUrl = "http://localhost:8080/core/search";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization",
				"bearer " + "fasdfafafaffdfdfdfdfdfdf-dfdfasfdsafdsfllerefdsfasfdasdfsdfdsryhbdgaagfdvdfgvdrfgr");

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("departForm", "Pune")
				.queryParam("goingTo", "BOM").queryParam("goingTo", "05-02-1988");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<ArrayList> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				ArrayList.class);

		// URI uri = new URI(baseUrl);
		//
		// Map<String, String> map = new HashMap<>();
		// // (@RequestHeader HttpHeaders httpHeaders,
		// // @RequestParam String departForm, @RequestParam String goingTo,
		// @RequestParam
		// // String date
		// map.put("departForm", "Pune");
		// map.put("goingTo", "BOM");
		// map.put("date", "05-02-1988");
		// ResponseEntity<ArrayList> response = restTemplate.g getForEntity(uri,
		// ArrayList.class, map);
		// assertEquals(HttpStatus.OK, response.getBody().ge);
		assertEquals(2, response.getBody().size());
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
