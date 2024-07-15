package com.stevedzakpasu.integrationtesting;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl {


    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Transactional
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
