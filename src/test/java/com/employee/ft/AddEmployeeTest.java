package com.employee.ft;

import com.employee.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static com.employee.Constants.URI_ADD_EMPLOYEE;
import static com.employee.Constants.URI_GET_EMPLOYEES;

@SpringBootTest
@AutoConfigureMockMvc
public class AddEmployeeTest {

    Employee emp = new Employee();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testPost() throws Exception {
        emp.setFname("aaa");
        emp.setLname("zzz");
        emp.setMob(33333333);
        String requestBody = objectMapper.writeValueAsString(emp);
        MvcResult mvcResult = sendPostRequest(URI_ADD_EMPLOYEE, requestBody);
        System.out.printf("Post Result:"+mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGet() throws Exception {
        MvcResult mvcResult = sendGetRequest(URI_GET_EMPLOYEES);
        System.out.printf("Get Result:"+mvcResult.getResponse().getContentAsString());
    }

    public MvcResult sendGetRequest(String uri) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        return mvcResult;
    }

    public MvcResult sendPostRequest(String uri, String requestBody) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        return mvcResult;
    }


}
