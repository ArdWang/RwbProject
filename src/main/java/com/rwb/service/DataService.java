package com.rwb.service;

import com.rwb.model.DataBean;

import java.util.List;

public interface DataService {

    DataBean getCurrentData(String dataaddre);

    int deleteData(String dataaddre);

}
