package com.rwb.service;

import com.rwb.model.ProbeBean;

import java.util.List;
import java.util.Map;

public interface ProbeService {

    List<ProbeBean> getProbe(Map<String,Object> params);

    int deleteProbe(Map<String,Object> params);

}
