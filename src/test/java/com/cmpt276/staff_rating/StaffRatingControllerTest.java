package com.cmpt276.staff_rating;

import com.cmpt276.staff_rating.controller.StaffRatingController;
import com.cmpt276.staff_rating.repository.StaffRatingRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StaffRatingController.class)
class StaffRatingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffRatingRepository staffRatingRepository;

    @Test
    void indexPageLoads() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("ratings"));
    }

    @Test
    void createRating_redirectsToIndex() throws Exception {
        mockMvc.perform(post("/ratings")
                .param("name", "Test Staff")
                .param("email", "test@example.com")
                .param("roleType", "PROF")
                .param("clarity", "8")
                .param("niceness", "6")
                .param("knowledgeableScore", "7")
                .param("comment", "Good")
            )
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"));
    }


}
