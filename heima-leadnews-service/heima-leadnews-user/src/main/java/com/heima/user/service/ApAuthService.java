package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.pojos.ApUserRealname;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.model.user.dtos.LoginDto;

public interface ApAuthService extends IService<ApUserRealname> {

    public ResponseResult list(AuthDto dto);
}
