package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotImpl {

    @Autowired
    private ParkingLotRepository parkingLotRepository;


    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
        ParkingLot parkingLot1 = parkingLotRepository.findByName(parkingLot.getName());
        return parkingLot1;
    }

    public ParkingLot deleteParkingLot(int id){
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElse(null);
        parkingLotRepository.deleteById(id);
        return parkingLot;
    }
}
