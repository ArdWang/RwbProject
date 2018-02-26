package com.rwb.model;

import java.util.List;

public class DeviceDataBean {
    /**
     * devicename : DESKTOP-JFU7JIJ
     * deviceaddre : a5:d9:79:9c:80:86
     * devicesymbol : 0
     * devicedata : [{"probe":"One","temp":21.9,"hum":"64%"}]
     */

    private String devicename;
    private String deviceaddre;
    private String devicesymbol;
    private List<DevicedataBean> devicedata;

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

    public List<DevicedataBean> getDevicedata() {
        return devicedata;
    }

    public void setDevicedata(List<DevicedataBean> devicedata) {
        this.devicedata = devicedata;
    }

    public static class DevicedataBean {
        /**
         * probe : One
         * temp : 21.9
         * hum : 64%
         */

        private String probe;
        private double temp;
        private String hum;

        public String getProbe() {
            return probe;
        }

        public void setProbe(String probe) {
            this.probe = probe;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }
    }
}
