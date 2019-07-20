package com.thoughtworks.parking_lot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
@Entity
@Table(name="Orders")
public class ParkingOrder {
    @Id
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "parking_name")
    private String parkingName;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "create_time")
    private String creationTime;

    @Column(name = "leave_time")
    private String leaveTime;

    @Column(name = "order_status")
    private char orderStatus;


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public char getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(char orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ParkingOrder(String parkingName, String carNumber) {
        this.parkingName = parkingName;
        this.carNumber = carNumber;
    }

    public ParkingOrder(String orderNumber, String parkingName, String carNumber, String creationTime, String leaveTime, char orderStatus) {
        this.orderNumber = orderNumber;
        this.parkingName = parkingName;
        this.carNumber = carNumber;
        this.creationTime = creationTime;
        this.leaveTime = leaveTime;
        this.orderStatus = orderStatus;
    }
}
