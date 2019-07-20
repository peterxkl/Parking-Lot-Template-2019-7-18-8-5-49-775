package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ParkingOrderImpl {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingOrder addParkingLotOrder(int id , ParkingOrder parkingOrder){
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElse(null);
        parkingLot.setSurplusCapacity(parkingLot.getSurplusCapacity()-1);

        String orderNumber = UUID.randomUUID().toString().substring(0,20);

        String parkingName = parkingLot.getName();

        Date date = new Date();
        DateFormat dt = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        String createTime = dt.format(date);

        ParkingOrder parkingOrder1 = new ParkingOrder(orderNumber,parkingName,parkingOrder.getCarNumber(),createTime,'1');

        parkingLot.getParkingOrders().add(parkingOrder1);

        parkingLotRepository.save(parkingLot);

        return parkingOrder1;
    }
}
