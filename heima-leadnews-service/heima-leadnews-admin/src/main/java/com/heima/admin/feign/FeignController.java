package com.heima.admin.feign;

import com.heima.admin.service.AdChannelLabelService;
import com.heima.model.admin.dtos.SelectByChannelIdDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 为模块间小调用而生
 */

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private AdChannelLabelService adChannelLabelService;

    @PostMapping("/channel_id")
    public ResponseResult channel_id(@RequestBody SelectByChannelIdDto dto){
        return adChannelLabelService.selectByChannelId(dto);
    }

}
