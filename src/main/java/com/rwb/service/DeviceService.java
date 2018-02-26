package com.rwb.service;

import com.rwb.model.DeviceBean;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    List<DeviceBean> getAllDevice(Map<String, Object> params);

    DeviceBean getDevice(Map<String, Object> params);

    DeviceBean addDevice(Map<String,Object> params);

    int queryDevice(String deviceaddre);


    DeviceBean updateDevice(DeviceBean deviceBean);

    int deleteDevice(Map<String,Object> params);


}
