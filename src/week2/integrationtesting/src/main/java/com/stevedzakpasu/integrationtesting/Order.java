package com.stevedzakpasu.integrationtesting;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private int quantity;

    public Order(Long id, String item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
