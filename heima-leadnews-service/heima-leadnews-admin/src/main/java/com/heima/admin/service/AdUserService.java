package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.admin.pojos.AdUser;
import com.heima.model.common.dtos.ResponseResult;

public interface AdUserService extends IService<AdUser> {

    /**
     * 自媒体端登录
     * @param dto
     * @return
     */
    ResponseResult login(AdUserDto dto);
}
