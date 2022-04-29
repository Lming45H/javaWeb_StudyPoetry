package com.lushannanlu.msg;

public class Message {
    private int code;//状态码：0：用户不存在 1：密码错误 2：成功
    private String msg;

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
