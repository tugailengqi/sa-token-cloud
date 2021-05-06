package com.lengqi.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {
    private Integer id;

    private Long userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}