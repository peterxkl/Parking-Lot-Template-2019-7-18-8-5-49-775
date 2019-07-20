package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ParkingOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkingLotRepository parkingLotRepository;


    @Test
    public void should_create_a_parking_lot_order() throws Exception {
        mockMvc.perform(post("/parking-lots/1").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t    \"parkingName\": \"停车场1号\",\n" +
                "        \"carNumber\": \"京A.888888\"\n" +
                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carNumber").value("京A.888888"));
    }
}