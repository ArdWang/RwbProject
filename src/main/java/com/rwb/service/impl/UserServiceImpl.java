package com.rwb.service.impl;

import com.rwb.mapper.UserMapper;
import com.rwb.model.UserBean;
import com.rwb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean getUser(Map<String,Object> params) {
        return userMapper.getUser(params);
    }

    @Override
    public List<UserBean> getAllUser() {
        return null;
    }

    @Override
    public UserBean addUser(Map<String, Object> params) {
        int add = userMapper.addUser(params);
        if(add>0){
            return userMapper.getUser(params);
        }
        return null;
    }

    @Override
    public int queryUser(String username) {
        UserBean userBean = userMapper.queryUser(username);
        if(userBean!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public UserBean updateUser(UserBean userBean) {
        if(userBean!=null){
            int update = userMapper.updateUser(userBean);
            if(update>0){
                Map<String,Object> params = new HashMap<>();
                params.put("username",userBean.getUsername());
                params.put("password",userBean.getPassword());
                return userMapper.getUser(params);
            }
        }
        return null;
    }

    @Override
    public int deleteUser(Map<String, Object> params) {
        int delete = userMapper.deleteUser(params);
        if(delete>0){
            return 1;
        }
        return 0;
    }

}
