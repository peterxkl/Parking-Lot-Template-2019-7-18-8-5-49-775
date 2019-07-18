package com.thoughtworks.parking_lot.dto;

import com.thoughtworks.parking_lot.model.ParkingLot;

import java.util.List;

public class ParkingLotPerPage {
    private int page;
    private List<ParkingLot> parkings;

    public ParkingLotPerPage(int page, List<ParkingLot> parkings) {
        this.page = page;
        this.parkings = parkings;
    }
}
