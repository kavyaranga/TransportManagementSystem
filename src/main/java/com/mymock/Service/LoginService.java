package com.mymock.Service;

import com.mymock.dao.ILoginDAO;
import com.mymock.domain.Bus;
import com.mymock.domain.Employee;
import com.mymock.domain.Stop;
import com.mymock.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rkavya on 3/24/2015.
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    public ILoginDAO iLoginDAO;

    @Override
    @Transactional
    public void addUser(User user){iLoginDAO.addUser(user);}

    @Override
    @Transactional
    public boolean login(User user) {
        return iLoginDAO.login(user);
    }

    @Override
    @Transactional
    public boolean addEmployee(Employee employee){ return iLoginDAO.addEmployee(employee);}

    @Override
    @Transactional
    public List<Stop> stopsList(){return iLoginDAO.stopsList();}

    @Override
    @Transactional
    public Bus selectedBus(int bus_id){return iLoginDAO.selectedBus(bus_id);}

    @Override
    @Transactional
    public Stop selectedStop(int stop_id){return iLoginDAO.selectedStop(stop_id);}

    @Override
    @Transactional
    public List<Bus> busList(int bus_id){return iLoginDAO.busList(bus_id);}
}
