package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment")// Name of table that is always underlined
public class Paymentt
{
//Primary Key -----------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid; //always a private long!~

    //Fields -------------------------------------------------
    @Column(nullable = false, //This overwrite the default and makes the field need a unique type & can't be null
    unique = true)
    private String type;

    //Join Tables -----------------------------------------------
    @ManyToMany(mappedBy = "payments")
    @JsonIgnoreProperties("payments")
    private Set<Order> orders = new HashSet<>();

    //Default Constructor ---------------------------------------
    public Paymentt() {
    }

    //Single Constructor -----------------------------------------

    public Paymentt(long paymentid, String type, Set<Order> orders) {
        this.paymentid = paymentid;
        this.type = type;
        this.orders = orders;
    }

    //Getters & Setters ------------------------------------------

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
