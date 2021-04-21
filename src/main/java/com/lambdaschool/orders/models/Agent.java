package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="agents")
public class Agent
{
    //Primary key ----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    //Fields -----------------------------------------------------------------------

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;


    //Join Tables -----------------------------------------------------------------
    @OneToMany(mappedBy = "agent", // When you do mapped by it must match a field that is in customer!
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "agent", //This will stop the infinate loop of reading data
        allowSetters = true)
    private List<Customer> customers = new ArrayList<>();

    //Default Constructor --------------------------------------------------------


    public Agent() {
    }

    //Single Constructor -------------------------------------------------------------

    public Agent(String agentname, String workingarea, double commission, String phone, String country, List<Customer> customers) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
        this.customers = customers;
    }

    //Getters & Setters ---------------------------------------------------------------

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
