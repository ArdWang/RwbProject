package com.rwb.data;


import com.rwb.model.UserBean;
import com.rwb.service.UserService;
import com.rwb.utils.json.user.UserObject;
import com.rwb.utils.json.user.UserOtherObject;
import com.rwb.utils.util.JackJsonUtils;
import com.rwb.utils.util.ResponseUtils;
import com.rwb.utils.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserData {

    @Autowired
    private UserService userService;

    public void getUserData(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        //单个用户登录接口
        if(actionString.equals("getUser")){
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                UserObject userObject = new UserObject();
                Map<String, Object> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                UserBean userBean = userService.getUser(params);

                if (userBean != null) {
                    userObject.setCode(StatusCode.CODE_SUCCESS);
                    userObject.setTips("ok");
                    userObject.setMessage(StatusCode.SUCCESS);
                    userObject.setUserBean(userBean);
                } else {
                    userObject.setCode(StatusCode.CODE_ERROR);
                    userObject.setTips("warm");
                    userObject.setMessage(StatusCode.ERROR);
                    userObject.setUserBean(null);
                }
                ResponseUtils.renderJson(response, JackJsonUtils.toJson(userObject));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //添加用户接口
        else if(actionString.equals("addUser")){
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Map<String, Object> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);

                int add = userService.queryUser(username);

                if (add > 0) {
                    UserOtherObject userOtherObject = new UserOtherObject();

                    userOtherObject.setCode(StatusCode.CODE_ERROR);
                    userOtherObject.setMessage(StatusCode.ERROR);
                    userOtherObject.setTips("账号已经被注册！");
                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(userOtherObject));
                } else {
                    UserObject userObject = new UserObject();
                    UserBean userBean = userService.addUser(params);

                    if (userBean != null) {
                        userObject.setCode(StatusCode.CODE_SUCCESS);
                        userObject.setTips("ok");
                        userObject.setMessage(StatusCode.SUCCESS);
                        userObject.setUserBean(userBean);
                    } else {
                        userObject.setCode(StatusCode.CODE_ERROR);
                        userObject.setTips("warm");
                        userObject.setMessage(StatusCode.ERROR);
                        userObject.setUserBean(null);
                    }

                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(userObject));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //更新用户
        else if(actionString.equals("updateUser")){
            try {
                int userid = request.getParameter("userid") != null && !request.getParameter("userid").equals("") ?
                        Integer.parseInt(request.getParameter("userid")) : 0;
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int age = request.getParameter("age") != null && !request.getParameter("age").equals("") ?
                        Integer.parseInt(request.getParameter("age")) : 0;
                String sex = request.getParameter("sex");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String hoby = request.getParameter("hoby");
                String note = request.getParameter("note");
                int admin = request.getParameter("admin") != null && !request.getParameter("admin").equals("") ?
                        Integer.parseInt(request.getParameter("admin")) : 0;

                UserObject userObject = new UserObject();

                UserBean userBean = new UserBean();
                userBean.setUserid(userid);
                userBean.setUsername(username);
                userBean.setPassword(password);
                userBean.setAge(age);
                userBean.setSex(sex);
                userBean.setPhone(phone);
                userBean.setEmail(email);
                userBean.setHoby(hoby);
                userBean.setNote(note);
                userBean.setAdmin(admin);

                userBean = userService.updateUser(userBean);

                if (userBean != null) {
                    userObject.setCode(StatusCode.CODE_SUCCESS);
                    userObject.setTips("ok");
                    userObject.setMessage(StatusCode.SUCCESS);
                    userObject.setUserBean(userBean);
                } else {
                    userObject.setCode(StatusCode.CODE_ERROR);
                    userObject.setTips("warm");
                    userObject.setMessage(StatusCode.ERROR);
                    userObject.setUserBean(null);
                }
                ResponseUtils.renderJson(response, JackJsonUtils.toJson(userObject));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //删除用户 管理员的权限
        else if(actionString.equals("deleteUser")){
            try {
                int userid = request.getParameter("userid") != null && !request.getParameter("userid").equals("") ?
                        Integer.parseInt(request.getParameter("userid")) : 0;
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int admin = request.getParameter("admin") != null && !request.getParameter("admin").equals("") ?
                        Integer.parseInt(request.getParameter("admin")) : 0;

                Map<String, Object> params = new HashMap<>();
                params.put("userid", userid);
                params.put("username", username);
                params.put("password", password);
                params.put("admin", admin);


                UserOtherObject userOtherObject = new UserOtherObject();
                int delete = userService.deleteUser(params);

                if (delete > 0) {
                    userOtherObject.setCode(StatusCode.CODE_SUCCESS);
                    userOtherObject.setMessage(StatusCode.SUCCESS);
                    userOtherObject.setTips("删除成功！");
                } else {
                    userOtherObject.setCode(StatusCode.CODE_ERROR);
                    userOtherObject.setMessage(StatusCode.ERROR);
                    userOtherObject.setTips("删除失败！");
                }

                ResponseUtils.renderJson(response, JackJsonUtils.toJson(userOtherObject));
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
