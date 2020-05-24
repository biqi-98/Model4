package com.Model4.task04;

import java.io.Serializable;

/**
 * User 类的特征有：用户名、密码(字符串类型)。
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6032427176835505254L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
