package com.heima.model.user.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class AuthDto {

    private Integer id;

    private String msg;

    private Integer page;

    private Integer size;

    /**
     * 状态
     */
    private Short status;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }

}
