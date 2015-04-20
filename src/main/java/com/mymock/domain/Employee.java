package com.mymock.domain;

import javax.persistence.*;

/**
 * Created by rkavya on 3/27/2015.
 */
@Entity
public class Employee {

    @Id
    private int employee_id;

    private String employee_name;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stop_id")
    private Stop stop;

    public Employee() {
    }


    public Employee(int employee_id, String employee_name, Bus bus, Stop stop) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.bus = bus;
        this.stop = stop;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }
}
