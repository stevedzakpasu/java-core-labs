package com.stevedzakpasu.integrationtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceImplIntegrationTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        // Given
        Order order = new Order();
        order.setItem("Laptop");
        order.setQuantity(1);

        // When
        Order savedOrder = orderService.saveOrder(order);

        // Then
        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getItem()).isEqualTo("Laptop");
        assertThat(savedOrder.getQuantity()).isEqualTo(1);

        // Verify the order is saved in the database
        Order fetchedOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertThat(fetchedOrder).isNotNull();
        assertThat(fetchedOrder.getItem()).isEqualTo("Laptop");
        assertThat(fetchedOrder.getQuantity()).isEqualTo(1);
    }
}
