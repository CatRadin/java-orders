package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers") //Name of table. It will always be underlined in red
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    //Fields ----------------------------------------------------------------
    @Column(nullable = false)
    private String custname;
    private String custcity;
    private String workinarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double reveiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    //Join Tables -------------------------------------------------------------
        //Many to one relationship with agent table. Many customers to one agent.
    @ManyToOne
    @JoinColumn(name = "agentcode",
        nullable = false)
    @JsonIgnoreProperties(value = "customers",
        allowSetters = true)
    private Agent agent;

        //One to Many relationship. One customer to many orders.
    @OneToMany(mappedBy = "customer",
        cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "customer",
        allowSetters = true)
    private List<Order> orders = new ArrayList<>();


}
