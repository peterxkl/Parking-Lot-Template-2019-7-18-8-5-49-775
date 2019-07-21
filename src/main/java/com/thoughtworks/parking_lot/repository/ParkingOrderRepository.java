package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrder , String> {
//    @Modifying
//    @Transactional
//    @Query("update Orders set leave_time= :#{#parkingorder.leaveTime} , order_status = :#{#parkingorder.orderStatus} where car_number = :#{#parkingorder.carNumber}")
//    int updateOrder(@Param(value = "parkingorder")ParkingOrder parkingorder);

}
