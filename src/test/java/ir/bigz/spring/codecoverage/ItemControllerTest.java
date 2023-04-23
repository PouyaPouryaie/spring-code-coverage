package ir.bigz.spring.codecoverage;


import ir.bigz.spring.codecoverage.common.JsonUtils;
import ir.bigz.spring.codecoverage.jacoco.controller.ItemController;
import ir.bigz.spring.codecoverage.jacoco.service.ItemService;
import ir.bigz.spring.codecoverage.jacoco.view.ItemRequest;
import ir.bigz.spring.codecoverage.jacoco.view.ItemResponse;
import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.UUID;

@WebMvcTest(value = {ItemController.class})
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemControllerTest {

    @MockBean
    ItemService itemService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void add_item_into_database_mock() throws Exception {


        //given
        ItemResponse itemResponse = ItemResponse.builder()
                .id(UUID.randomUUID().toString())
                .itemName("Item Mobile")
                .category("mobile")
                .quantity(10)
                .price(new BigDecimal("10.000")).build();
        BDDMockito.given(this.itemService.createItem(Mockito.any())).willReturn(itemResponse);

        ItemRequest itemRequest = new ItemRequest("Item Mobile", "mobile", 10, new BigDecimal("10.000"));

        //then
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/item/v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(itemRequest)))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        Assertions.assertNotNull(mvcResult.getResponse().getContentAsString());

    }
}
