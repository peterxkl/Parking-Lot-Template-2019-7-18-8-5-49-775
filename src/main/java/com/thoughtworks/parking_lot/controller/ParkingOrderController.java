package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingOrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingOrderController {

    @Autowired
    private ParkingOrderImpl parkingOrderImpl;

    @PostMapping("/parking-lots/{id}")
    public ParkingOrder addParkingLotOrder(@PathVariable int id , @RequestBody ParkingOrder parkingOrder){
        return parkingOrderImpl.addParkingLotOrder(id , parkingOrder);
    }
    @PutMapping("/parking-lots/{id}")
    public ParkingOrder updateParkingLotOrder(@PathVariable int id , @RequestBody ParkingOrder parkingOrder){
        return parkingOrderImpl.addParkingLotOrder(id , parkingOrder);
    }
}
