package com.thoughtworks.parking_lot.repository;


import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot ,Integer> {
//    @Modifying
//    @Transactional
//    @Query("update ParkingLot set parking_lot.parkingOrders.leave_time= :#{#parkingorder.leaveTime} , order_status = :#{#parkingorder.orderStatus} where carNumber = :#{#parkingorder.carNumber}")
//    int updateOrder(@Param(value = "parking_lot") ParkingLot parking_lot);

}
