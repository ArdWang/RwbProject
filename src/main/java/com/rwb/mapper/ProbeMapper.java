package com.rwb.mapper;

import com.rwb.model.ProbeBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface ProbeMapper {

    /**
     * 查询时间段的数据
     * 介意为1个小时的数据
     * @param params
     * @return
     */
    @Select("select * from probe_tb where probetime>=#{begintime} and probetime<=#{endtime} " +
            "and deviceid=#{deviceid} and probename=#{probename} ORDER BY probetime ASC")
    List<ProbeBean> getProbe(Map<String,Object> params);

    /**
     * 删除Probe表的数据
     * 根据传入的时间段删除数据
     * @param params
     * @return
     */
    @Delete("delete from probe_tb where probetime>=#{begintime} and probetime<=#{endtime}" +
            " and deviceid=#{deviceid} and probename=#{probename}")
    int deleteProbe(Map<String,Object> params);
}
