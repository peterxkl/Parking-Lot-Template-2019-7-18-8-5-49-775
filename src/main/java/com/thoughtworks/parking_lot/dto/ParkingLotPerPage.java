package com.thoughtworks.parking_lot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.parking_lot.model.ParkingLot;

import java.util.List;
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ParkingLotPerPage {
    private int page;
    private List<ParkingLot> parkings;

    public ParkingLotPerPage(int page, List<ParkingLot> parkings) {
        this.page = page;
        this.parkings = parkings;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ParkingLot> getParkings() {
        return parkings;
    }

    public void setParkings(List<ParkingLot> parkings) {
        this.parkings = parkings;
    }
}
