package com.stevedzakpasu;


public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderRepository.save(order);
    }
}