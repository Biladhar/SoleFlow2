package com.bilel.soleflow2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.models.Order;
import com.bilel.soleflow2.repositories.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //create an order
	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

    //update an order
	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

    //get an order by id
	@Override
	public Order getOrder(Long idOrder) {
		return orderRepository.findById(idOrder).get();
	}

    //delete an order
	@Override
	public void deleteOrder(Long idOrder) {
		orderRepository.deleteById(idOrder);
		
	}

    //get all orders
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}


    //find an order by raw material id
	@Override
	public List<Order> findByRawMaterialIdRm(Long idRm) {
		return orderRepository.findByRawMaterialIdRm(idRm);
	}


    //find an order by Status
	@Override
	public List<Order> findByOrderStatus(Order.OrderStatus orderStatus) {
		return orderRepository.findByOrderStatus(orderStatus);
	}

}
