package com.rwb.service.impl;

import com.rwb.mapper.ProbeMapper;
import com.rwb.model.ProbeBean;
import com.rwb.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProbeServiceImpl implements ProbeService{

    @Autowired
    private ProbeMapper probeMapper;

    @Override
    public List<ProbeBean> getProbe(Map<String, Object> params) {
        return probeMapper.getProbe(params);
    }

    @Override
    public int deleteProbe(Map<String, Object> params) {
        int delete = probeMapper.deleteProbe(params);
        if(delete>0){
            return 1;
        }
        return 0;
    }
}
