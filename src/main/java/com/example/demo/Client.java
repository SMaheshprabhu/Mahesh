package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender", length = 1)
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id")
    private Balance balance;

    public Client() {}

    public Client(String name, int age, String gender, long balanceValue) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.balance = new Balance(balanceValue);
    }

   
    public Integer getId() 
    { return id; }
    public void setId(Integer id)
     { this.id = id; }

    public String getName()
     { return name; }
    public void setName(String name) 
    { this.name = name; }

    public int getAge()
     { return age; }
    public void setAge(int age)
     { this.age = age; }

    public String getGender() 
    { return gender; }
    public void setGender(String gender) 
    { this.gender = gender; }

    public Balance getBalance()
     { return balance; }
    public void setBalance(Balance balance) 
    { this.balance = balance; }
}
