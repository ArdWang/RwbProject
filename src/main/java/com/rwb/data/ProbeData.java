package com.rwb.data;

import com.rwb.model.ProbeBean;
import com.rwb.service.ProbeService;
import com.rwb.utils.json.probe.ProbeListObject;
import com.rwb.utils.json.probe.ProbeObject;
import com.rwb.utils.util.JackJsonUtils;
import com.rwb.utils.util.ResponseUtils;
import com.rwb.utils.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProbeData {
    @Autowired
    private ProbeService probeService;


    public void getProbeTime(HttpServletRequest request, HttpServletResponse response){
        String actionString = request.getParameter("action");

        //根据时间获取探头的数据
        if(actionString.equals("getProbe")){
            ProbeListObject probeListObject = new ProbeListObject();
            try {
                int deviceid = request.getParameter("deviceid") != null && !request.getParameter("deviceid").equals("") ?
                        Integer.parseInt(request.getParameter("deviceid")) : 0;
                Long begintime = Long.parseLong(request.getParameter("begintime"));
                Long endtime = Long.parseLong(request.getParameter("endtime"));
                String probename = request.getParameter("probename");

                Map<String, Object> params = new HashMap<>();
                params.put("begintime", begintime);
                params.put("endtime", endtime);
                params.put("deviceid", deviceid);
                params.put("probename", probename);

                List<ProbeBean> list = probeService.getProbe(params);

                if (list.size() > 0) {
                    probeListObject.setCode(StatusCode.CODE_SUCCESS);
                    probeListObject.setTips("ok");
                    probeListObject.setMessage(StatusCode.SUCCESS);
                    probeListObject.setProbes(list);
                } else {
                    probeListObject.setCode(StatusCode.CODE_ERROR);
                    probeListObject.setTips("warm");
                    probeListObject.setMessage(StatusCode.ERROR);
                    probeListObject.setProbes(null);
                }
            }catch (Exception e){
                e.printStackTrace();
                probeListObject.setCode(StatusCode.CODE_ERROR);
                probeListObject.setTips("warm");
                probeListObject.setMessage(StatusCode.ERROR);
                probeListObject.setProbes(null);
            }
            ResponseUtils.renderJson(response, JackJsonUtils.toJson(probeListObject));
        }

        //删除Probe表的数据
        else if(actionString.equals("deleteProbe")){
            ProbeObject probeObject = new ProbeObject();
            try {
                int deviceid = request.getParameter("deviceid") != null && !request.getParameter("deviceid").equals("") ?
                        Integer.parseInt(request.getParameter("deviceid")) : 0;
                Long begintime = Long.parseLong(request.getParameter("begintime"));
                Long endtime = Long.parseLong(request.getParameter("endtime"));
                String probename = request.getParameter("probename");

                Map<String, Object> params = new HashMap<>();
                params.put("begintime", begintime);
                params.put("endtime", endtime);
                params.put("deviceid", deviceid);
                params.put("probename", probename);

                int delete = probeService.deleteProbe(params);

                if(delete>0){
                    probeObject.setCode(StatusCode.CODE_SUCCESS);
                    probeObject.setTips(StatusCode.SUCCESS);
                    probeObject.setMessage("删除成功");
                }else{
                    probeObject.setCode(StatusCode.CODE_ERROR);
                    probeObject.setTips(StatusCode.ERROR);
                    probeObject.setMessage("删除失败");
                }

            }catch (Exception e){
                e.printStackTrace();
                probeObject.setCode(StatusCode.CODE_ERROR);
                probeObject.setTips(StatusCode.ERROR);
                probeObject.setMessage("删除失败");
            }
            ResponseUtils.renderJson(response, JackJsonUtils.toJson(probeObject));
        }
    }
}
