package com.heima.model.admin.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class AdChannel {

    private String name;

    private Boolean status;

    private String description;

    private Integer ord;

    private Integer id;

    private boolean isDefault;

    private Date createTime;
}
