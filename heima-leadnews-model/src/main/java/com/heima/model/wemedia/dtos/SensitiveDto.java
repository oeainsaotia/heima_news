package com.heima.model.wemedia.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SensitiveDto {

    protected Integer size;
    protected Integer page;
    protected  String name;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }
}
