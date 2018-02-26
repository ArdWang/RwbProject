package com.rwb.utils.json.current;

import com.rwb.model.DeviceDataBean;

import java.util.List;

public class CurrentListObject {
    private String tips;
    private String code;
    private String message;

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDeviceaddre() {
        return deviceaddre;
    }

    public void setDeviceaddre(String deviceaddre) {
        this.deviceaddre = deviceaddre;
    }

    public String getDevicesymbol() {
        return devicesymbol;
    }

    public void setDevicesymbol(String devicesymbol) {
        this.devicesymbol = devicesymbol;
    }

    public List<DeviceDataBean.DevicedataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DeviceDataBean.DevicedataBean> datas) {
        this.datas = datas;
    }

    private String devicename;
    private String deviceaddre;
    private String devicesymbol;
    private List<DeviceDataBean.DevicedataBean> datas;
}
