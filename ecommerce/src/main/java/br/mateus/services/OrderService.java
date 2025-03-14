package br.mateus.services;

import br.mateus.entity.Order;
import br.mateus.exception.InvalidInputException;
import br.mateus.exception.ResourceNotFoundException;
import br.mateus.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new InvalidInputException("Invalid order details");
        }
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public Order updateOrder(Long id, Order orderDetails) {
        if (orderDetails.getItems() == null || orderDetails.getItems().isEmpty()) {
            throw new InvalidInputException("Invalid order details");
        }
        Order order = getOrderById(id);
        order.setItems(orderDetails.getItems());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
