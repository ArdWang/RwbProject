package com.rwb.controller;

import com.rwb.data.CurrentData;
import com.rwb.data.DeviceData;
import com.rwb.data.ProbeData;
import com.rwb.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {
    /**
     * 用户块
     */
    @Autowired
    private UserData userData;

    /**
     * 设备块
     */
    @Autowired
    private DeviceData deviceData;

    /**
     * 当前的数据
     */
    @Autowired
    private CurrentData currentData;

    /**
     * 探头的数据获取
     */
    @Autowired
    private ProbeData probeData;



    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/getDoc")
    public String getDoc(){
        return "doc";
    }


    @RequestMapping(value = "/getData",method = RequestMethod.GET)
    public void getAllDtaGet(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        if(actionString.equals("getUser")||actionString.equals("addUser")||actionString.equals("deleteUser")
                ||actionString.equals("updateUser")){
            userData.getUserData(request,response);
        }

        else if(actionString.equals("getAllDevice")||actionString.equals("addDevice")
                ||actionString.equals("updateDevice")||actionString.equals("deleteDevice")){
            deviceData.getDeviceData(request,response);
        }

        else if(actionString.equals("getCurrent")||actionString.equals("deleteData")){
            currentData.getCurrentData(request,response);
        }

        else if(actionString.equals("getProbe")||actionString.equals("deleteProbe")){
            probeData.getProbeTime(request,response);
        }
    }

    @RequestMapping(value = "/getData",method = RequestMethod.POST)
    public void getAllDtaPost(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        if(actionString.equals("getUser")||actionString.equals("addUser")||actionString.equals("deleteUser")
                ||actionString.equals("updateUser")){
            userData.getUserData(request,response);
        }
        else if(actionString.equals("getAllDevice")||actionString.equals("addDevice")
                ||actionString.equals("updateDevice")||actionString.equals("deleteDevice")){
            deviceData.getDeviceData(request,response);
        }

        else if(actionString.equals("getCurrent")||actionString.equals("deleteData")){
            currentData.getCurrentData(request,response);
        }

        else if(actionString.equals("getProbe")||actionString.equals("deleteProbe")){
            probeData.getProbeTime(request,response);
        }
    }


}
