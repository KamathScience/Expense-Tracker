package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryResourceControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CategoryService categoryService;

    @Test
    public void shouldGetAllCategoriesTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());

    }

    @Test
    public void shouldPostCategoriesTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(post("/api/categories?httpServletRequest,categoryMap")).andDo(print()).andExpect(status().isForbidden());

    }

    @Test
    public void shouldGetCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldUpdateCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1?httpServletRequest,category")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldDeleteCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
       mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGetAllCategoriesValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories?httpServletRequest")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldPostCategoriesValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(post("/api/categories?httpServletRequest,categoryMap")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldGetCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1?httpServletRequest,category")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }
}