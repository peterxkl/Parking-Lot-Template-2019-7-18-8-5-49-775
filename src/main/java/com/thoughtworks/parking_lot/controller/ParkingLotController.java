package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ParkingLotController {

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
    public List<ParkingLot> getAllParkingLotByPage(@RequestParam(value = "page",required = false,defaultValue = "0")int page){
        return parkingLotImpl.getAllParkingLotByPage(page);
    }

    @GetMapping("/parking-lots/{id}")
    public ParkingLot getParkingLotById(@PathVariable int id){
        return parkingLotImpl.getParkingLotById(id);
    }

    @PutMapping("/parking-lots")
    public ParkingLot updateParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotImpl.updateParkingLot(parkingLot);
    }

}
