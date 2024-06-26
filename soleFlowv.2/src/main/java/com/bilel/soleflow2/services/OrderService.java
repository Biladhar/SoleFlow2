package com.bilel.soleflow2.services;

import java.util.List;



import com.bilel.soleflow2.models.Order;

public interface OrderService {

    Order createOrder(Order order);
    Order updateOrder(Order order);
    Order getOrder(Long idOrder );
    void deleteOrder(Long idOrder);
    List<Order> getAllOrders();
    List<Order> findByRawMaterialIdRm(Long idRm);
    List<Order> findByOrderStatus(Order.OrderStatus orderStatus);

}
