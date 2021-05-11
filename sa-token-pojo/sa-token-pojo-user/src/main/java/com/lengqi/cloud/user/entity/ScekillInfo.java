package com.lengqi.cloud.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "scekill_info")
public class ScekillInfo implements Serializable {
    @TableId(value = "scekill_id", type = IdType.INPUT)
    private Integer scekillId;

    @TableField(value = "scekill_username")
    private String scekillUsername;

    @TableField(value = "scekill_phone")
    private String scekillPhone;

    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_SCEKILL_ID = "scekill_id";

    public static final String COL_SCEKILL_USERNAME = "scekill_username";

    public static final String COL_SCEKILL_PHONE = "scekill_phone";

    public static final String COL_CREATE_TIME = "create_time";
}