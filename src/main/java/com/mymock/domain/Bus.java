package com.mymock.domain;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by rkavya on 3/27/2015.
 */
@Entity
public class Bus {
    @Id
    private int bus_id;

    private String name;

    private int seats;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="RouteMap",
            joinColumns = {
                    @JoinColumn(name="bus_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="stop_id")
            })
    private Set<Stop> stop;

    public Bus() {
    }

    public Bus(int bus_id, String name, int seats, Set<Stop> stop) {
        this.bus_id = bus_id;
        this.name = name;
        this.seats = seats;
        this.stop = stop;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public Set<Stop> getStop() {
        return stop;
    }

    public void setStop(Set<Stop> stop) {
        this.stop = stop;
    }
}
