package com.lengqi.cloud.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysPermissions implements Serializable {
    private Integer id;

    private String name;

    private Integer pid;

    private String url;

    private String perms;

    private String icon;

    /**
    * 类型 0菜单 1按钮
    */
    private Integer type;

    /**
    * 0隐藏,1显示
    */
    private Integer isShow;

    private Integer orderNum;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}