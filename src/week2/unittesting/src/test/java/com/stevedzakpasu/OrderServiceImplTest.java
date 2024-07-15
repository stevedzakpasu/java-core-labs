package com.stevedzakpasu;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    void testSaveOrder() {

        Order order = new Order();
        order.setOrderId("123");
        order.setProduct("Laptop");
        order.setQuantity(1);

        when(orderRepository.save(order)).thenReturn(true);


        boolean result = orderService.saveOrder(order);


        assertTrue(result);
        verify(orderRepository, times(1)).save(order);
    }
}
