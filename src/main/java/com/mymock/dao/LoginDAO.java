package com.mymock.dao;

import com.mymock.domain.Bus;
import com.mymock.domain.Employee;
import com.mymock.domain.Stop;
import com.mymock.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rkavya on 3/24/2015.
 */
@Repository
public class LoginDAO  implements ILoginDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user){

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean login(User user) {

        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username and u.password=:password");

        query.setString("username",user.getUsername());
        query.setString("password",user.getPassword());

        User us = (User)query.uniqueResult();

        if((us.getUsername().equals(user.getUsername()))&&(us.getPassword().equals(user.getPassword())))
        {
          return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean addEmployee(Employee employee){
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.employee_id=:employee_id ");

        query.setInteger("employee_id", employee.getEmployee_id());

        if(query.uniqueResult()== null)
        {
            sessionFactory.getCurrentSession().save(employee);
            return true;
        }
        else
        {
          return false;
        }
    }

    @Override
    public List<Stop> stopsList(){

        return sessionFactory.getCurrentSession().createQuery("from Stop").list();

    }

    @Override
    public List<Bus> busList(int bus_id){
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select r.bus_id from RouteMap r where r.stop_id=:bus_id");

        query.setInteger("bus_id", bus_id);

        List<Bus> b = (List<Bus>) query.list();

        List<Bus> buses = new ArrayList<Bus>();

        Iterator iterator = b.iterator();
        while (iterator.hasNext())
        {
            Query q = sessionFactory.getCurrentSession().createQuery("from Bus b where b.bus_id=:bus_id");
            q.setString("bus_id", (iterator.next()).toString());

            buses.add((Bus)q.uniqueResult());

        }

        return buses;


    }

    @Override
    public Bus selectedBus(int bus_id){

        Query query = sessionFactory.getCurrentSession().createQuery("from Bus b where b.bus_id=:bus_id");

        query.setInteger("bus_id", bus_id);

        Bus b = (Bus)query.uniqueResult();
        return b;
    }

    @Override
    public Stop selectedStop(int stop_id){

        Query query = sessionFactory.getCurrentSession().createQuery("from Stop s where s.stop_id=:stop_id");

        query.setInteger("stop_id", stop_id);

        Stop s = (Stop)query.uniqueResult();
        return s;
    }

    public boolean addBus(Bus bus)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("from Bus b where b.bus_id=:bus_id ");

        query.setInteger("bus_id", bus.getBus_id());

        if(query.uniqueResult()== null)
        {
            sessionFactory.getCurrentSession().save(bus);
            return true;
        }
        else
        {
            return false;
        }

    }

   /* public boolean addStops(List<Stop> stops)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("from Bus b where b.bus_id=:bus_id ");

        query.setInteger("bus_id", bus.getBus_id());

        if(query.uniqueResult()== null)
        {
            sessionFactory.getCurrentSession().save(bus);
            return true;
        }
        else
        {
            return false;
        }

    }*/
}
