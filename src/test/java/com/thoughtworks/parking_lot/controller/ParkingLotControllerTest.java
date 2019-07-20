package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ParkingLotControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Test
    public void should_create_a_parking_lot() throws Exception {
        mockMvc.perform(post("/parking-lots").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"name\": \"停车场6号\",\n" +
                "    \"capacity\": 400,\n" +
                "    \"position\": \"横琴1号\"\n" +
                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("停车场6号"));
    }

    @Test
    public void should_return_parking_lot_when_delete_a_parking_lot() throws Exception {
        ParkingLot parkingLot = parkingLotRepository.save(new ParkingLot("停车场6号",150,"横琴1号",150));
        mockMvc.perform(delete("/parking-lots/{id}",parkingLot.getId()))
                .andDo(print())
                .andExpect(jsonPath("$.name").value("停车场6号"));
    }
    @Test
    public void should_return_parking_lot_by_id() throws Exception{
        ParkingLot parkingLot = parkingLotRepository.findAll().get(0);
        mockMvc.perform(get("/parking-lots/{id}",parkingLot.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(parkingLot.getName()));
    }

    @Test
    public void should_return_parking_lots_by_page() throws Exception{
        int size = parkingLotRepository.findAll().size();
        int result=15;
        if(size<15) result = size;
        mockMvc.perform(get("/parking-lots?page={page}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(result));
    }

    @Test
    public void should_update_parking_lot_the_capacity() throws Exception{
        mockMvc.perform(post("/parking-lots").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"id\": 99,\n" +
                "    \"name\": \"停车场7号\",\n" +
                "    \"capacity\": 450,\n" +
                "    \"position\": \"唐家湾7号\"\n" +
                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.capacity").value(450));
    }
}