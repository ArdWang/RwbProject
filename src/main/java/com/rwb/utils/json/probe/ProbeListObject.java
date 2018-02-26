package com.rwb.utils.json.probe;

import com.rwb.model.ProbeBean;

import java.util.List;

public class ProbeListObject {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProbeBean> getProbes() {
        return probes;
    }

    public void setProbes(List<ProbeBean> probes) {
        this.probes = probes;
    }

    private String tips;
    private String message;
    private List<ProbeBean> probes;
}
