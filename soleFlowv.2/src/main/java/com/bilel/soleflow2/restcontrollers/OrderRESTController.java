package com.bilel.soleflow2.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilel.soleflow2.models.Order;
import com.bilel.soleflow2.models.Order.OrderStatus;
import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.services.OrderService;
import com.bilel.soleflow2.services.RawMaterialService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderRESTController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private RawMaterialService rawMaterialService;

    //get all orders
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    //create an order
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
    	Long idRm = order.getRawMaterial().getIdRm();
    	RawMaterial rm = rawMaterialService.convertDtoToEntity(rawMaterialService.getRawMaterial(idRm));
    	Double priceperUnit = rm.getPriceRm();
    	int quantity = order.getOrderQuantity();
    	order.setOrderAmount(priceperUnit * quantity);
    	order.setOrderStatus(OrderStatus.PENDING);
        return orderService.createOrder(order);
    }

    //get an order by id
    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }

    //update an order
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    //delete an order
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    //find an order by raw material id
    @GetMapping("/getByRawMaterialIdRm/{idRm}")
    public List<Order>findByRawMaterialIdRm(@PathVariable("idRm") Long idRm) {
        return orderService.findByRawMaterialIdRm(idRm);
    }

    //find an order by Status
    @GetMapping("/getByOrderStatus/{orderStatus}")
    public List<Order> findByOrderStatus(@PathVariable("orderStatus") Order.OrderStatus orderStatus) {
        return orderService.findByOrderStatus(orderStatus);
    }

    // Order Status to Delivred
    @PutMapping("/delivered/{id}")
    public Order deliveredOrder(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        Long idRm = order.getRawMaterial().getIdRm();
        RawMaterial rm = rawMaterialService.convertDtoToEntity(rawMaterialService.getRawMaterial(idRm));
        rm.setStockRm(rm.getStockRm() + order.getOrderQuantity());
        rm.setAmountRm(rm.getStockRm() * rm.getPriceRm());
        order.setOrderStatus(OrderStatus.DELIVERED);
        rawMaterialService.updateRawMaterial(rawMaterialService.convertEntityToDto(rm));
        return orderService.updateOrder(order);
    }

    





}
