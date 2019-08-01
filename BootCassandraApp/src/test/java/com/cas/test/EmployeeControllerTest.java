
/** 
 * Author: Shivam_Chandel
 *
 */

package com.cas.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.cas.config.CassandraApplication;
import com.cas.controller.EmployeeController;
import com.cas.entity.Employee;
import com.cas.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CassandraApplication.class })
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	ObjectMapper objectMapper = new ObjectMapper();
	MvcResult mvcResult = null;

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	// to mock dependency,your rest contoller might need to execute
	@MockBean
	private EmployeeService employeeService;

	// setup method to intialise mock mvc object to be used later
	@Before
	public void initialise() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getAllEmployeesTest() throws Exception {
		RequestBuilder requestBuilderGet = MockMvcRequestBuilders.get("/cas/getAllEmployees")
				.accept(MediaType.APPLICATION_JSON);
		mvcResult = mockMvc.perform(requestBuilderGet).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("The status of the GET test case : " + mvcResult.getResponse().getStatus());
		Assert.assertTrue("GET test case passed", mvcResult.getResponse().getStatus() == 200);
	}

	@Test
	public void createEmployeeTest() throws Exception {

		Employee emp = new Employee(90, "mockName", "mockUnit", 0);
		String responseBody = objectMapper.writeValueAsString(emp);
		RequestBuilder requestBuilderPost = MockMvcRequestBuilders.post("/cas/createEmployee").content(responseBody)
				.accept(MediaType.APPLICATION_JSON);
		mvcResult = mockMvc.perform(requestBuilderPost).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("The status of the POST test case : " + mvcResult.getResponse().getStatus());
		Assert.assertTrue("POST test case passed", mvcResult.getResponse().getStatus() == 201);
	}

	@Test
	public void deleteEmployeeTest() throws Exception {

		RequestBuilder requestBuilderDelete = MockMvcRequestBuilders.delete("/cas/deleteEmployee/{id}", "4")
				.accept(MediaType.APPLICATION_JSON);
		mvcResult = mockMvc.perform(requestBuilderDelete).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("The status of the DELETE test case : " + mvcResult.getResponse().getStatus());
		Assert.assertTrue("DELETE test case passed", mvcResult.getResponse().getStatus() == 200);
	}

	@Test
	public void updateEmployeeTest() throws Exception {

		Employee updatedEmp = new Employee(1, "updatedName", "updatedUnit", 60000);
		String responseBody = objectMapper.writeValueAsString(updatedEmp);
		RequestBuilder requestBuilderPut = MockMvcRequestBuilders.put("/cas/updateEmployee/{id}", "1")
				.content(responseBody).accept(MediaType.APPLICATION_JSON);
		mvcResult = mockMvc.perform(requestBuilderPut).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("The status of the PUT test case : " + mvcResult.getResponse().getStatus());
		Assert.assertTrue("PUT test case passed", mvcResult.getResponse().getStatus() == 200);
	}

}
