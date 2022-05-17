package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
class CategoryResourceControllerIntegerationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void shouldGetAllCategoriesTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        List<Category> categories = new ArrayList<>();
        when(categoryService.fetchAllCategories(1, 2)).thenReturn(categories);
        mockMvc.perform(get("/api/categories?httpServletRequest")).andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    public void shouldPostCategoriesTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Map<String , Object> categoryMap = new HashMap<>();
        categoryMap.put("title", "title");
        categoryMap.put("description", "description");
        Category category = new Category(1,1,"title", "description", 0.00);
        when(categoryService.addCategory(1, 2, "title", "description")).thenReturn(category);
        mockMvc.perform(post("/api/categories?httpServletRequest,categoryMap")).andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    public void shouldGetCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
        when(categoryService.fetchCategoryById(1, 2, 1)).thenReturn(category);
        mockMvc.perform(get("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldUpdateCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
//        when(categoryService.updateCategory(1, 2, 1, category)).;
        mockMvc.perform(put("/api/categories/1?httpServletRequest,category")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldDeleteCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
//        when(categoryService.updateCategory(1, 2, 1, category)).;
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isBadRequest());
    }
    @Test
    public void shouldGetAllCategoriesValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        List<Category> categories = new ArrayList<>();
        when(categoryService.fetchAllCategories(1, 2)).thenReturn(categories);
        mockMvc.perform(get("/api/categories?httpServletRequest")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldPostCategoriesValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Map<String , Object> categoryMap = new HashMap<>();
        categoryMap.put("title", "title");
        categoryMap.put("description", "description");
        Category category = new Category(1,1,"title", "description", 0.00);
        when(categoryService.addCategory(1, 2, "title", "description")).thenReturn(category);
        mockMvc.perform(post("/api/categories?httpServletRequest,categoryMap")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldGetCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
        when(categoryService.fetchCategoryById(1, 2, 1)).thenReturn(category);
        mockMvc.perform(get("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
//        when(categoryService.updateCategory(1, 2, 1, category)).;
        mockMvc.perform(put("/api/categories/1?httpServletRequest,category")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Category category = new Category(1,1,"title", "description", 0.00);
//        when(categoryService.updateCategory(1, 2, 1, category)).;
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }



}