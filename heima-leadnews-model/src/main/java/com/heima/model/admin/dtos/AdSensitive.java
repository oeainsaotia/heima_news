package com.heima.model.admin.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class AdSensitive {
    /**
     * id
     */
    private Integer id;
    /**
     * sensitive
     */
    private String sensitives;

    private Date createTime;
}
