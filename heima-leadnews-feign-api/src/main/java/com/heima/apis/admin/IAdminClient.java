package com.heima.apis.admin;

import com.heima.model.admin.dtos.SelectByChannelIdDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("leadnews-admin")
public interface IAdminClient {

    @PostMapping("/feign/channel_id")
    public ResponseResult channel_id(@RequestBody SelectByChannelIdDto dto);
}
