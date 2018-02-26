package com.rwb.service.impl;

import com.rwb.mapper.DataMapper;
import com.rwb.model.DataBean;
import com.rwb.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    private DataMapper dataMapper;



    @Override
    public DataBean getCurrentData(String dataaddre) {
        return dataMapper.getCurrentData(dataaddre);
    }

    @Override
    public int deleteData(String dataaddre) {
        int delete = dataMapper.deleteData(dataaddre);
        if(delete>0){
            return 1;
        }
        return 0;
    }
}
