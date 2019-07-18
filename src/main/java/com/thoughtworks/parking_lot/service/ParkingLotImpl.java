package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dto.ParkingLotPerPage;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<ParkingLotPerPage> getAllParkingLotByPage(){
        List<ParkingLotPerPage> parkingLotPerPages = new ArrayList<>();
        List<ParkingLot> list = parkingLotRepository.findAll();
        for(int i = 0 ,j = 1; i < list.size() ; j++){
            List<ParkingLot> parkingLots = new ArrayList<>();
            for(int k = 0 ; k <15 ; k++){
                if(i>=list.size()){
                    break;
                }
                parkingLots.add(list.get(i++));
            }
            parkingLotPerPages.add(new ParkingLotPerPage(j,parkingLots));
        }
        return parkingLotPerPages;
    }

    public ParkingLot getParkingLotById(int id){
        ParkingLot parkingLot =  parkingLotRepository.findById(id).orElse(null);
        return parkingLot;
    }
}
