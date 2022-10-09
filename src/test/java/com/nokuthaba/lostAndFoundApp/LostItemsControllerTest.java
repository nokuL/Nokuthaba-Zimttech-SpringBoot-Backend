package com.nokuthaba.lostAndFoundApp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nokuthaba.lostAndFoundApp.controller.LostItemsController;
import com.nokuthaba.lostAndFoundApp.dao.LostItemsDao;
import com.nokuthaba.lostAndFoundApp.entity.LostItem;
import com.nokuthaba.lostAndFoundApp.service.LostItemsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = LostItemsController.class)
public class LostItemsControllerTest  {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LostItemsService lostItemsService;

    @MockBean
    LostItemsDao  lostItemsDao;


    LostItem lostItem;


    @BeforeEach
    void before(){
        lostItem = new LostItem();


    }

    @Test
    public void testFindAllLostItems() throws  Exception{
        List<LostItem> itemList = new ArrayList<>();
        when(lostItemsService.findAllLostItems()).thenReturn(itemList);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/lostItemsList");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult =resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());


    }

    @Test
    @DisplayName("Test create new item")
    public void testCreateItem()throws  Exception{
          when(lostItemsService.recordLostItem(lostItem)).thenReturn(lostItem);
        ObjectMapper objectMapper = new ObjectMapper();
        String item_string = objectMapper.writeValueAsString(lostItem);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/recordLostItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(item_string);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200, mockHttpServletResponse.getStatus());
    }

    @Test
    @DisplayName("Test edit item")
    public void testEditItem()throws  Exception{
        when(lostItemsService.editLostItem(lostItem)).thenReturn(lostItem);
        ObjectMapper objectMapper = new ObjectMapper();
        String item_string = objectMapper.writeValueAsString(lostItem);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.put("/edit-lost-item")
                .contentType(MediaType.APPLICATION_JSON)
                .content(item_string);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assertions.assertEquals(200 , mockHttpServletResponse.getStatus());

    }

    @Test
    @DisplayName("Test Delete item")
    public void deleteItem() throws  Exception{
        doNothing().when(lostItemsDao).deleteById(1L);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete("/delete/lost-item/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        Assertions.assertEquals(200, status);
    }


}









