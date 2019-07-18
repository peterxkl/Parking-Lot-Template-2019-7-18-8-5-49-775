package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    public void should_return_ParkingLot_By_Name(){
        parkingLotRepository.save(new ParkingLot("停车场1号",256,"金鼎1号"));
        ParkingLot parkingLot = parkingLotRepository.findByName("停车场1号");
        assertEquals("金鼎1号",parkingLot.getPosition());

    }
}