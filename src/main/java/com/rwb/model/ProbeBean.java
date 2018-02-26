package com.rwb.model;

/**
 * 探头表bean
 */
public class ProbeBean {
    private Integer probeid;

    public Integer getProbeid() {
        return probeid;
    }

    public void setProbeid(Integer probeid) {
        this.probeid = probeid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getProbename() {
        return probename;
    }

    public void setProbename(String probename) {
        this.probename = probename;
    }

    public String getProbetemp() {
        return probetemp;
    }

    public void setProbetemp(String probetemp) {
        this.probetemp = probetemp;
    }

    public String getProbesymbol() {
        return probesymbol;
    }

    public void setProbesymbol(String probesymbol) {
        this.probesymbol = probesymbol;
    }

    public String getProbehum() {
        return probehum;
    }

    public void setProbehum(String probehum) {
        this.probehum = probehum;
    }

    public Long getProbetime() {
        return probetime;
    }

    public void setProbetime(Long probetime) {
        this.probetime = probetime;
    }

    private Integer deviceid;
    private String probename;
    private String probetemp;
    private String probesymbol;
    private String probehum;
    private Long probetime;
}
