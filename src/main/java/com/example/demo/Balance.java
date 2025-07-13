package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Amount")
    private long amount;

    public Balance() {}

    public Balance(long amount) {
        this.amount = amount;
    }

    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public long getAmount() { return amount; }
    public void setAmount(long amount) { this.amount = amount; }
}
