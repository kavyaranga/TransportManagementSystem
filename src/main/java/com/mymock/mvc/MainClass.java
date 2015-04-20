package com.mymock.mvc;

import com.mymock.Service.ILoginService;
import com.mymock.domain.Bus;
import com.mymock.domain.Employee;
import com.mymock.domain.Stop;
import com.mymock.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;


/**
 * Created by rkavya on 3/19/2015.
 */

@Controller
public class MainClass{

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.put("account", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login( @ModelAttribute(value = "account")User user,ModelMap model,HttpSession session)
    {
        System.out.println(user.getUsername()+"    "+user.getPassword());
        if(iLoginService.login(user)) {
            model.put("stopsList",iLoginService.stopsList());
            model.put("employee", new Employee());
            model.put("stop", new Stop());
            model.put("bus", new Bus());

            if(user.getUsername().equals("admin"))
                return "adminWelcome";
            else
                return "welcome";
        }
        else
        {
            model.put("message", "Login failed");
            model.put("account", new User());
            return "login";
        }

    }

    @RequestMapping(value = "/loginForm",method = RequestMethod.GET)
    public  @ResponseBody User loginUser( @RequestBody User user,ModelMap model,HttpSession session)
    {
        System.out.println("Entered Controller");
        if(iLoginService.login(user))
            return user;
        else
            return new User("user doesnot exists","");
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
   public String addEmployee(@ModelAttribute(value = "stop")Stop stop,@ModelAttribute(value = "bus")Bus bus,ModelMap modelMap,HttpSession session,BindingResult result,@RequestParam String employeeName,@RequestParam String employeeId,@RequestParam String stop_id,@RequestParam String bus_id){

        modelMap.put("bus", new Bus());
        modelMap.put("stop", new Stop());
        //modelMap.put("busesList",iLoginService.busList(Integer.valueOf(stop_id)));
       // modelMap.put("stopsList",iLoginService.stopsList());
        System.out.println("Entered Stop Id" + stop_id);
        Employee employee = new Employee();

        employee.setEmployee_name(employeeName);
        employee.setEmployee_id(Integer.valueOf(employeeId));

        session.setAttribute("username",employee.getEmployee_id());


        Bus b = iLoginService.selectedBus(Integer.valueOf(bus_id));

        Stop s = iLoginService.selectedStop(Integer.valueOf(stop_id));

        System.out.println("Bus Id is :" +b.getBus_id());

        employee.setStop(s);
        employee.setBus(b);
        boolean resultReturned =  iLoginService.addEmployee(employee);

        if (resultReturned) {
            modelMap.put("message", "Employee Added");
            return "main";
        }
         else
        {
            modelMap.put("message", "Employee Already Exists");
            return "main";
        }

   }
    @RequestMapping(value = "/busList", method = RequestMethod.POST)
    public String busList(@ModelAttribute(value = "stop")Stop stop,ModelMap modelMap,HttpSession session,BindingResult result,@RequestParam String stop_id){


        modelMap.put("employee",new Employee());
        modelMap.put("bus", new Bus());
        modelMap.put("stop", new Stop());
        modelMap.put("busesList",iLoginService.busList(Integer.valueOf(stop_id)));
        modelMap.put("stopsList",iLoginService.stopsList());

        System.out.println("bus list-----"+iLoginService.busList(Integer.valueOf(stop_id)));
        System.out.println("Stop List====" + iLoginService.stopsList());
        Stop s = iLoginService.selectedStop(Integer.valueOf(stop_id));
        modelMap.put("SelectedStop", s.getName());
        modelMap.put("selectedStopId",s.getStop_id());
        return "welcome";

    }

    @RequestMapping(value = "/addBus", method = RequestMethod.POST)
    public String addNewBus( @ModelAttribute(value = "newBus")Bus bus,ModelMap model,HttpSession session)
    {
       /* System.out.println(user.getUsername()+"    "+user.getPassword());
        if(iLoginService.login(user)) {
            model.put("stopsList",iLoginService.stopsList());
            model.put("employee", new Employee());
            model.put("stop", new Stop());
            model.put("bus", new Bus());

            if(user.getUsername().equals("admin"))
                return "adminWelcome";
            else
                return "welcome";
        }
        else
        {
            model.put("message", "Login failed");
            model.put("account", new User());
            return "login";
        }*/

        model.put("bus", new Bus());

        return "welcome";

    }

}