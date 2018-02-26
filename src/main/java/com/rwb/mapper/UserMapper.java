package com.rwb.mapper;

import com.rwb.model.UserBean;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * 用户接口
 * create by xiaowang 2017/12/25
 */
public interface UserMapper {
    /**
     * 通过用户和密码 返回一个userbean对象 获取单个用户的信息
     * @param params
     * @return
     */
    @Select("select * from user_tb where username=#{username} and password=#{password}")
    UserBean getUser(Map<String,Object> params);

    /**
     * 获取所有的用户信息 通过权限来获取 管理员的权限
     * @param params
     * @return
     */
    @Select("select * from user_tb where username=#{username} and password=#{password} admin=#{admin}")
    List<UserBean> getAllUser(Map<String,Object> params);

    /**
     * 添加用户的接口
     * @param params
     * @return
     */
    @Insert("insert into user_tb(username,password) values(#{username},#{password})")
    int addUser(Map<String,Object> params);


    /**
     * 查询用户是否存在相同的用户名
     * @param username
     * @return
     */
    @Select("select * from user_tb where username=#{username}")
    UserBean queryUser(@Param("username") String username);


    /**
     * 更新用户信息
     * @param userBean
     * @return
     */
    @Update("update user_tb set username=#{username},password=#{password},age =#{age},sex =#{sex},phone"
            + "=#{phone},email=#{email},hoby=#{hoby},note=#{note},admin=#{admin} where userid=#{userid}")
    int updateUser(UserBean userBean);


    /**
     * 删除用户信息 需要管理员的权限
     * @param params
     * @return
     */
    @Delete("delete from user_tb where userid=#{userid} and username=#{username} and password=#{password} " +
            "and admin=#{admin}")
    int deleteUser(Map<String,Object> params);

}
