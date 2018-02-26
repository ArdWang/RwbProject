package com.rwb.service;

import com.rwb.model.UserBean;
import java.util.List;
import java.util.Map;


public interface UserService {

    UserBean getUser(Map<String,Object> params);

    List<UserBean> getAllUser();

    UserBean addUser(Map<String,Object> params);

    int queryUser(String username);

    UserBean updateUser(UserBean userBean);

    int deleteUser(Map<String,Object> params);
}
