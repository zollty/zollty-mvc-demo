package com.zollty.mvcdemo.lesson1.vo;

/**
 * 记录用户注册信息
 * @author zollty
 * @since 2014年8月31日
 */
public class RegistVO {
    
    private String username;
    
    private String password;
    
    private String contact;
    
    
    // ~ setters and getters
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
