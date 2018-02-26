package com.rwb.mapper;

import com.rwb.model.DataBean;
import com.rwb.model.DeviceDataBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface DataMapper {

    /**
     * 获取得到设备的数据
     * @param dataaddre
     * @return
     */
    @Select("select * from data_tb where dataaddre=#{dataaddre}")
    DataBean getCurrentData(@Param("dataaddre") String dataaddre);

    /**
     * 获取所有的设备数据
     */
    @Select("select * from data_tb")
    List<DataBean> getAllData();

    /**
     * 删除Data数据
     * @param dataaddre
     * @return
     */
    @Delete("delete from data_tb where dataaddre=#{dataaddre}")
    int deleteData(@Param("dataaddre") String dataaddre);



}
