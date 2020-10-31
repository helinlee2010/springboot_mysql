package com.example.springboot_mysql;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMockitoApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    ObjectMapper om = new ObjectMapper();

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void addUserParamTest() throws Exception{
        MvcResult res = mockMvc.perform(
                post("/users/add-with-param").param("name","TestWithParam").param("age", "21")
        ).andExpect(status().isOk()).andReturn();

        String resultContent = res.getResponse().getContentAsString();

        System.out.println(resultContent);
    }

//    @Test
//    public void addUserJsonTest() throws Exception{
//        User user = new User();
//        user.setName("TestUserJson");
//        user.setAge(19);
//
//        String jsonRequest = om.writeValueAsString(user);
//
//        MvcResult res = mockMvc.perform(
//                post("/users/add-with-json").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)
//        ).andExpect(status().isOk()).andReturn();
//
//        String resultContent = res.getResponse().getContentAsString();
//        System.out.println("ResultContent is:" + resultContent);
//
//        Response response = om.readValue(resultContent, Response.class);
//        System.out.println("response from om readvalue is: "+ response);
//        Assert.assertTrue(response.isSuccess()==Boolean.TRUE);
//
//    }

}
