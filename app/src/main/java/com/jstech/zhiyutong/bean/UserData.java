package com.jstech.zhiyutong.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/28.
 */

public class UserData implements Serializable {

    private String usrName;

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    private String usrPassword;


}
