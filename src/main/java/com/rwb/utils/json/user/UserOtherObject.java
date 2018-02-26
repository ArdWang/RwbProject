package com.rwb.utils.json.user;

/**
 * 用户单个接口的输出
 * 删除 查询是否相同的
 */
public class UserOtherObject {

    private String code;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String tips;
    private String message;
}
