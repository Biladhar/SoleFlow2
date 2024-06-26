package com.bilel.soleflow2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bilel.soleflow2.models.Order;
@RepositoryRestResource(path = "restorders")
public interface OrderRepository extends JpaRepository<Order, Long>{



    //add a method that finds an order by raw material id
    List<Order> findByRawMaterialIdRm(Long idRm);


    //find an order by Status
    List<Order> findByOrderStatus(Order.OrderStatus orderStatus);


}
