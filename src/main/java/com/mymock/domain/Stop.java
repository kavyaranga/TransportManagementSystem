package com.mymock.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by rkavya on 3/27/2015.
 */
@Entity
public class Stop {

    @Id
    private int stop_id;

    private String name;

    private Date inTime;

    private Date OutTime;

    @ManyToMany(mappedBy="stop")
    private Set<Bus> busSet;


    public int getStop_id() {
        return stop_id;
    }

    public void setStop_id(int stop_id) {
        this.stop_id = stop_id;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return OutTime;
    }

    public void setOutTime(Date outTime) {
        OutTime = outTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
