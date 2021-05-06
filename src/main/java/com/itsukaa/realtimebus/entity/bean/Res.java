package com.itsukaa.realtimebus.entity.bean;

public class Res {
    private Integer code;
    private String msg;
    private Object res;

    public Res(Integer code, String msg, Object res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
    }

    @Override
    public String toString() {
        return "Res{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", res=" + res +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }
}
