package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.dto.ParkingLotPerPage;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingLotAPI {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingLotImpl parkingLotImpl;

    @PostMapping("/parking-lots")
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        return  parkingLotImpl.addParkingLot(parkingLot);
    }

    @DeleteMapping("/parking-lots/{id}")
    public ParkingLot deleteParkingLot(@PathVariable int id){
         return parkingLotImpl.deleteParkingLot(id);
    }

    @GetMapping("/parking-lots")
    public List<ParkingLotPerPage> getAllParkingLotByPage(){
        return parkingLotImpl.getAllParkingLotByPage();
    }

    @GetMapping("/parking-lots/{id}")
    public ParkingLot getParkingLotById(@PathVariable int id){
        return parkingLotImpl.getParkingLotById(id);
    }

    

}
