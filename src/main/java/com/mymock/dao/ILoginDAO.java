package com.mymock.dao;

import com.mymock.domain.Bus;
import com.mymock.domain.Employee;
import com.mymock.domain.Stop;
import com.mymock.domain.User;

import java.util.List;

/**
 * Created by rkavya on 3/24/2015.
 */
public interface ILoginDAO {

    boolean login(User user);
    void addUser(User user);
    boolean addEmployee(Employee employee);
    List<Stop> stopsList();
    Bus selectedBus(int bus_id);
    Stop selectedStop(int bus_id);
    List<Bus> busList(int bus_id);
}
