package com.rwb.service.impl;

import com.rwb.mapper.DeviceMapper;
import com.rwb.model.DeviceBean;
import com.rwb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<DeviceBean> getAllDevice(Map<String, Object> params) {
        return deviceMapper.getAllDevice(params);
    }

    @Override
    public DeviceBean getDevice(Map<String, Object> params) {
        return deviceMapper.getDevice(params);
    }

    @Override
    public DeviceBean addDevice(Map<String, Object> params) {
        int add = deviceMapper.addDevice(params);
        if(add>0){
            String deviceaddre = params.get("deviceaddre").toString();
            DeviceBean deviceBean = deviceMapper.queryDevice(deviceaddre);
            if(deviceBean!=null) {
                return deviceBean;
            }
        }
        return null;
    }

    @Override
    public int queryDevice(String deviceaddre) {
        DeviceBean deviceBean = deviceMapper.queryDevice(deviceaddre);
        if(deviceBean!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public DeviceBean updateDevice(DeviceBean deviceBean) {
        if(deviceBean!=null){
            int update = deviceMapper.updateDevice(deviceBean);
            if(update>0){
                String deviceaddre = deviceBean.getDeviceaddre();
                DeviceBean deviceBeans = deviceMapper.queryDevice(deviceaddre);
                if(deviceBeans!=null) {
                    return deviceBeans;
                }
            }
        }
        return null;
    }

    @Override
    public int deleteDevice(Map<String, Object> params) {
        int delete = deviceMapper.deleteDevice(params);
        if(delete>0){
            return 1;
        }
        return 0;
    }
}
