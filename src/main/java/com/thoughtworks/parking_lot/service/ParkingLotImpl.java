package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParkingLotImpl {

    @Autowired
    private ParkingLotRepository parkingLotRepository;


    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot deleteParkingLot(int id){
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElse(null);
        parkingLotRepository.deleteById(id);
        return parkingLot;
    }

    public List<ParkingLot> getAllParkingLotByPage(int page){
        if(page == 0){
            return parkingLotRepository.findAll();
        }
        return parkingLotRepository.findAll(PageRequest.of(page-1,15)).getContent();
    }

    public ParkingLot getParkingLotById(int id){
        return parkingLotRepository.findById(id).orElse(null);
    }

    public ParkingLot updateParkingLot(ParkingLot parkingLot){
        ParkingLot parkingLot1 = parkingLotRepository.findById(parkingLot.getId()).orElse(null);
        parkingLot1.setCapacity(parkingLot.getCapacity());
        parkingLotRepository.save(parkingLot1);
        return parkingLotRepository.findById(parkingLot.getId()).orElse(null);
    }
}
