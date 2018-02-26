package com.rwb.mapper;

import com.rwb.model.DeviceBean;
import com.rwb.model.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 数据库的增，删，查，改
 */

public interface DeviceMapper {

    /**
     * 查询用户的设备
     * @param params
     * @return
     */
    @Select("select  * from device_tb where userid=#{userid} and username=#{username}")
    List<DeviceBean> getAllDevice(Map<String, Object> params);

    /**
     * 添加设备返回的值
     * @param params
     * @return
     */
    @Select("select * from device_tb where deviceid=#{deviceid} and deviceaddre=#{deviceaddre}")
    DeviceBean getDevice(Map<String,Object> params);


    /**
     * 添加设备
     * @param params
     * @return
     */
    @Insert("insert into device_tb(userid,username,devicename,deviceaddre,addtime)" +
            "values(#{userid},#{username},#{devicename},#{deviceaddre},#{addtime})")
    int addDevice(Map<String,Object> params);

    /**
     * 查询用户是否存在相同的设备
     * @param deviceaddre
     * @return
     */
    @Select("select * from device_tb where deviceaddre=#{deviceaddre}")
    DeviceBean queryDevice(@Param("deviceaddre") String deviceaddre);


    /**
     * 更新设备信息
     * @param deviceBean
     * @return
     */
    @Update("update device_tb set userid=#{userid},username=#{username}," +
            "devicename=#{devicename},deviceaddre=#{deviceaddre},addtime=#{addtime}" +
            " where deviceid=#{deviceid}")
    int updateDevice(DeviceBean deviceBean);

    /**
     * 删除设备信息
     * @param params
     * @return
     */
    @Delete("delete from device_tb where deviceid=#{deviceid} and userid=#{userid} and username=#{username}")
    int deleteDevice(Map<String,Object> params);

}
