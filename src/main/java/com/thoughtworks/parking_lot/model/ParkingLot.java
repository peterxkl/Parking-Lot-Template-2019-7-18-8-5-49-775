package com.thoughtworks.parking_lot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Parking")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private int capacity;

    private String position;

    @Column(name = "surplus_capacity")
    private int surplusCapacity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingLot_Id")
    private List<ParkingOrder> parkingOrders;

    public ParkingLot() {
    }

    public ParkingLot(String name, int capacity, String position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
        this.surplusCapacity = capacity;
    }

    public int getSurplusCapacity() {
        return surplusCapacity;
    }

    public void setSurplusCapacity(int surplusCapacity) {
        this.surplusCapacity = surplusCapacity;
    }

    public List<ParkingOrder> getParkingOrders() {
        return parkingOrders;
    }

    public void setParkingOrders(List<ParkingOrder> parkingOrders) {
        this.parkingOrders = parkingOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
