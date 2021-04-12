package com.lambdaschool.orders.models;

import javax.persistence.*;

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

}
