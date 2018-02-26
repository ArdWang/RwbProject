package com.rwb.data;

import com.rwb.model.DeviceBean;
import com.rwb.service.DeviceService;
import com.rwb.utils.json.device.DeviceListObject;
import com.rwb.utils.json.device.DeviceObject;
import com.rwb.utils.json.device.DeviceOtherObject;
import com.rwb.utils.util.JackJsonUtils;
import com.rwb.utils.util.ResponseUtils;
import com.rwb.utils.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceData {
    @Autowired
    private DeviceService deviceService;

    public void getDeviceData(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        //获取所有的设备
        if(actionString.equals("getAllDevice")){
            try {
                String username = request.getParameter("username");
                String userid = request.getParameter("userid");

                DeviceListObject deviceListObject = new DeviceListObject();

                Map<String, Object> params = new HashMap<>();
                params.put("username", username);
                params.put("userid", userid);

                List<DeviceBean> list = deviceService.getAllDevice(params);

                if (list.size() > 0) {
                    deviceListObject.setCode(StatusCode.CODE_SUCCESS);
                    deviceListObject.setTips("ok");
                    deviceListObject.setMessage(StatusCode.SUCCESS);
                    deviceListObject.setDevices(list);
                } else {
                    deviceListObject.setCode(StatusCode.CODE_ERROR);
                    deviceListObject.setTips("warm");
                    deviceListObject.setMessage(StatusCode.ERROR);
                    deviceListObject.setDevices(null);
                }

                ResponseUtils.renderJson(response, JackJsonUtils.toJson(deviceListObject));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //添加设备
        else if(actionString.equals("addDevice")){
            try {
                int userid = request.getParameter("userid") != null && !request.getParameter("userid").equals("") ?
                        Integer.parseInt(request.getParameter("userid")) : 0;

                String username = request.getParameter("username");
                String devicename = request.getParameter("devicename");
                String deviceaddre = request.getParameter("deviceaddre");

                Long deviceaddtime = Long.parseLong(request.getParameter("addtime"));

                Map<String, Object> params = new HashMap<>();
                params.put("userid", userid);
                params.put("username", username);
                params.put("devicename", devicename);
                params.put("deviceaddre", deviceaddre);
                params.put("addtime", deviceaddtime);

                int query = deviceService.queryDevice(deviceaddre);

                if (query > 0) {
                    DeviceOtherObject deviceOtherObject = new DeviceOtherObject();

                    deviceOtherObject.setCode(StatusCode.CODE_ERROR);
                    deviceOtherObject.setMessage(StatusCode.ERROR);
                    deviceOtherObject.setTips("不能重复的添加设备");

                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(deviceOtherObject));
                } else {

                    DeviceObject deviceObject = new DeviceObject();
                    DeviceBean deviceBean = deviceService.addDevice(params);

                    if (deviceBean != null) {
                        deviceObject.setCode(StatusCode.CODE_SUCCESS);
                        deviceObject.setTips("ok");
                        deviceObject.setMessage(StatusCode.SUCCESS);
                        deviceObject.setDeviceBean(deviceBean);
                    } else {
                        deviceObject.setCode(StatusCode.CODE_ERROR);
                        deviceObject.setTips("wram");
                        deviceObject.setMessage(StatusCode.ERROR);
                        deviceObject.setDeviceBean(null);
                    }
                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(deviceObject));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //更新设备
        else if(actionString.equals("updateDevice")){
            try {
                int deviceid = request.getParameter("deviceid") != null && !request.getParameter("deviceid").equals("") ?
                        Integer.parseInt(request.getParameter("deviceid")) : 0;

                int userid = request.getParameter("userid") != null && !request.getParameter("userid").equals("") ?
                        Integer.parseInt(request.getParameter("userid")) : 0;

                String username = request.getParameter("username");
                String devicename = request.getParameter("devicename");
                String deviceaddre = request.getParameter("deviceaddre");

                Long addtime = Long.parseLong(request.getParameter("addtime"));

                DeviceObject deviceObject = new DeviceObject();

                DeviceBean deviceBean = new DeviceBean();

                deviceBean.setDeviceid(deviceid);
                deviceBean.setUserid(userid);
                deviceBean.setUsername(username);
                deviceBean.setDevicename(devicename);
                deviceBean.setDeviceaddre(deviceaddre);
                deviceBean.setAddtime(addtime);

                deviceBean = deviceService.updateDevice(deviceBean);

                if (deviceBean != null) {
                    deviceObject.setCode(StatusCode.CODE_SUCCESS);
                    deviceObject.setTips("ok");
                    deviceObject.setMessage(StatusCode.SUCCESS);
                    deviceObject.setDeviceBean(deviceBean);
                } else {
                    deviceObject.setCode(StatusCode.CODE_SUCCESS);
                    deviceObject.setTips("ok");
                    deviceObject.setMessage(StatusCode.SUCCESS);
                    deviceObject.setDeviceBean(null);
                }

                ResponseUtils.renderJson(response, JackJsonUtils.toJson(deviceObject));
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //删除设备
        else if(actionString.equals("deleteDevice")){
            try {
                int deviceid = request.getParameter("deviceid") != null && !request.getParameter("deviceid").equals("") ?
                        Integer.parseInt(request.getParameter("deviceid")) : 0;
                int userid = request.getParameter("userid") != null && !request.getParameter("userid").equals("") ?
                        Integer.parseInt(request.getParameter("userid")) : 0;
                String username = request.getParameter("username");

                Map<String, Object> params = new HashMap<>();
                params.put("deviceid", deviceid);
                params.put("userid", userid);
                params.put("username", username);
                DeviceOtherObject deviceOtherObject = new DeviceOtherObject();
                int delete = deviceService.deleteDevice(params);

                if (delete > 0) {
                    deviceOtherObject.setCode(StatusCode.CODE_SUCCESS);
                    deviceOtherObject.setMessage(StatusCode.SUCCESS);
                    deviceOtherObject.setTips("删除成功");
                } else {
                    deviceOtherObject.setCode(StatusCode.CODE_ERROR);
                    deviceOtherObject.setMessage(StatusCode.ERROR);
                    deviceOtherObject.setTips("删除失败");
                }

                ResponseUtils.renderJson(response, JackJsonUtils.toJson(deviceOtherObject));
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
