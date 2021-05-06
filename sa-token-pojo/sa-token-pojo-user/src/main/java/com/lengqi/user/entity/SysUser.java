package com.lengqi.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String email;

    private String phone;

    /**
    * 状态 0锁定 1有效
    */
    private String sstate;

    /**
    * 性别 0男 1女
    */
    private String ssex;

    /**
    * 个人描述
    */
    private String remarks;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private static final long serialVersionUID = 1L;
}