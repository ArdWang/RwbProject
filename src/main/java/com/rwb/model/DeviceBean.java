package com.rwb.model;

/**
 * 设备的bean
 */
public class DeviceBean {

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    private Integer deviceid;
    private Integer userid;
    private String username;
    private String devicename;
    private String deviceaddre;

    public Long getAddtime() {
        return addtime;
    }

    public void setAddtime(Long addtime) {
        this.addtime = addtime;
    }

    private Long addtime;
}
