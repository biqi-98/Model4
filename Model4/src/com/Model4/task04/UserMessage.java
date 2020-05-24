package com.Model4.task04;

import java.io.Serializable;

/**
 * UserMessage 类的特征有：类型(字符串类型) 和 用户对象(User 类型)。
 */
public class UserMessage implements Serializable {

    private static final long serialVersionUID = -7308843195216896975L;

    private User user;

    private String type;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserMessage() {
    }

    public UserMessage(User user, String type) {
        this.user = user;
        this.type = type;
    }
}
