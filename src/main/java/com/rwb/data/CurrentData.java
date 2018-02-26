package com.rwb.data;

import com.google.gson.Gson;
import com.rwb.model.DataBean;
import com.rwb.model.DeviceDataBean;
import com.rwb.service.DataService;
import com.rwb.utils.json.current.CurrentListObject;
import com.rwb.utils.json.current.CurrentOtherObject;
import com.rwb.utils.util.JackJsonUtils;
import com.rwb.utils.util.ResponseUtils;
import com.rwb.utils.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CurrentData {

    @Autowired
    private DataService dataService;

    public void getCurrentData(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        //到当前设备的数据
        if (actionString.equals("getCurrent")) {
            CurrentListObject currentListObject = new CurrentListObject();
            List<DeviceDataBean.DevicedataBean> datalist = new ArrayList<>();

            try {
                String dataaddre = request.getParameter("dataaddre");

                DataBean data = dataService.getCurrentData(dataaddre);

                if(data!=null) {
                    String json = data.getData();
                    if (json!=null) {
                        Gson gson = new Gson();
                        DeviceDataBean dataBean = gson.fromJson(json, DeviceDataBean.class);
                        datalist = dataBean.getDevicedata();

                        if (datalist.size() > 0) {
                            currentListObject.setCode(StatusCode.CODE_SUCCESS);
                            currentListObject.setTips("ok");
                            currentListObject.setMessage("success");
                            currentListObject.setDevicename(dataBean.getDevicename());
                            currentListObject.setDeviceaddre(dataBean.getDeviceaddre());
                            currentListObject.setDevicesymbol(dataBean.getDevicesymbol());
                            currentListObject.setDatas(datalist);
                        } else {
                            currentListObject.setCode(StatusCode.CODE_ERROR);
                            currentListObject.setTips("warm");
                            currentListObject.setMessage("error");
                            currentListObject.setDatas(null);
                        }
                    } else {
                        //datalist = null;
                        currentListObject.setCode(StatusCode.CODE_ERROR);
                        currentListObject.setTips("warm");
                        currentListObject.setMessage("error");
                        currentListObject.setDatas(null);
                    }
                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(currentListObject));
                }else{
                    currentListObject.setCode(StatusCode.CODE_ERROR);
                    currentListObject.setTips("warm");
                    currentListObject.setMessage("error");
                    currentListObject.setDatas(null);
                    ResponseUtils.renderJson(response, JackJsonUtils.toJson(currentListObject));
                }

            } catch (Exception e) {
                e.printStackTrace();
                currentListObject.setCode(StatusCode.CODE_ERROR);
                currentListObject.setTips("warm");
                currentListObject.setMessage("error");
                currentListObject.setDatas(null);
                ResponseUtils.renderJson(response, JackJsonUtils.toJson(currentListObject));
            }
        }


        //删除当前设备数据
        else if(actionString.equals("deleteData")){
            CurrentOtherObject currentOtherObject = new CurrentOtherObject();
            try{
                String dataaddre = request.getParameter("dataaddre");

                int delete = dataService.deleteData(dataaddre);

                if(delete>0){
                    currentOtherObject.setCode(StatusCode.CODE_SUCCESS);
                    currentOtherObject.setMessage(StatusCode.SUCCESS);
                    currentOtherObject.setTips("删除成功");
                }else{
                    currentOtherObject.setCode(StatusCode.CODE_ERROR);
                    currentOtherObject.setMessage(StatusCode.ERROR);
                    currentOtherObject.setTips("删除失败");
                }

                ResponseUtils.renderJson(response, JackJsonUtils.toJson(currentOtherObject));

            }catch (Exception e){
                e.printStackTrace();
                currentOtherObject.setCode(StatusCode.CODE_ERROR);
                currentOtherObject.setMessage(StatusCode.ERROR);
                currentOtherObject.setTips("删除失败");
                ResponseUtils.renderJson(response, JackJsonUtils.toJson(currentOtherObject));

            }
        }
    }
}
