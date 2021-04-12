package com.lambdaschool.orders.models;

import com.lambdaschool.orders.models.Paymentt;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Entity allows interaction with the orders table
@Entity
@Table(name = "orders") //Table name will always be underlined in red.
public class Order
{
    //The Primary Key ----------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    //Fields-----------------------------------------------------------------------
    //these become columns & are all lowercase so they are easier to work with.
    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    //Join Tables------------------------------------------------------------------

    //Joins orders and payments in a many to many relationship.
    @ManyToMany
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name ="ordernum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Paymentt>payments = new HashSet<>(); //A set forces us to have unique values!~

    //A many to many relationship with the customer table. Many orders to one customer.
    @ManyToOne
    @JoinColumn(name = "custcode",
            nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    //Default constructor -------------------------------------------------------------
    public Order() {
    }
    //"Single" constructor -----------------------------------------------------------

    public Order(double ordamount, double advanceamount, String orderdescription, Set<Paymentt> payments, Customer customer) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.payments = payments;
        this.customer = customer;
    }


    //Getters & Setters ------------------------------------------------------------------

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Set<Paymentt> getPayments() {
        return payments;
    }

    public void setPayments(Set<Paymentt> payments) {
        this.payments = payments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}