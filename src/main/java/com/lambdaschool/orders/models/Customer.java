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
    @JsonIgnoreProperties(value = "customer",//This will stop the infinate loop of reading data
        allowSetters = true)
    private List<Order> orders = new ArrayList<>();

    //Default Constructor -----------------------------------------------------------


    public Customer() {
    }

    //Single Constructor ---------------------------------------------------------------

    public Customer(String custname, String custcity, String workinarea, String custcountry, String grade, double openingamt, double reveiveamt, double paymentamt, double outstandingamt, String phone, Agent agent, List<Order> orders) {
        this.custname = custname;
        this.custcity = custcity;
        this.workinarea = workinarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.reveiveamt = reveiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
        this.orders = orders;
    }

    //Getters & Setters ----------------------------------------------------------------


    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkinarea() {
        return workinarea;
    }

    public void setWorkinarea(String workinarea) {
        this.workinarea = workinarea;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getReveiveamt() {
        return reveiveamt;
    }

    public void setReveiveamt(double reveiveamt) {
        this.reveiveamt = reveiveamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
