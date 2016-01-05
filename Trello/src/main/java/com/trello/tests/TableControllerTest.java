package com.trello.tests;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.trello.model.TableList;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class TableControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext wac;
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).dispatchOptions(true).build();
    }

    @Test
    public void viewTablesTest() throws Exception {
    	MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/viewTables");
		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		result.andExpect(model().attributeExists("tables"));
		result.andExpect(view().name("tableList"));
    }

    @Test
    public void tablePageTest() throws Exception {
    	MockHttpServletRequestBuilder addingTableRequest = MockMvcRequestBuilders.get("/addTable/TableTest");
		mockMvc.perform(addingTableRequest);
		
    	MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/tablePage/0/TableTest");
		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		result.andExpect(model().attributeExists("tableIndex"));
		result.andExpect(model().attributeExists("tableName"));
		result.andExpect(view().name("tablePage"));
     }
}

