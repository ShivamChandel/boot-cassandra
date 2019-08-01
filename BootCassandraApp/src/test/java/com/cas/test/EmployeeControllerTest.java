
/** 
 * Author: Shivam_Chandel
 *
 */

package com.cas.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cas.config.CassandraApplication;
import com.cas.controller.EmployeeController;
import com.cas.entity.Employee;
import com.cas.service.EmployeeService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CassandraApplication.class })
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;

	Employee empMockObj = new Employee(0, "mockName", "mockUnit", 0);

	@Test
	public void getAllEmployeesTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cas/getAllEmployees")
				.accept(MediaType.APPLICATION_JSON);
		Integer status = mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus();
		System.out.println("The status of the GET test case : " + status);
		// assertEquals("", 200, status);
	}

	@Test
	public void createEmployeeTest() throws Exception {

	}

	@Test
	public void deleteEmployeeTest() throws Exception {

	}

	@Test
	public void updateEmployeeTest() throws Exception {

	}

}
