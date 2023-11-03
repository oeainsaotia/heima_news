package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.admin.dtos.AdSensitive;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.wemedia.service.WmSensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sensitive")
public class WmSensitiveController {

    @Autowired
    private WmSensitiveService wmSensitiveService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody SensitiveDto dto){
        return wmSensitiveService.list(dto);
    }

    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable int id){
        return wmSensitiveService.delete(id);
    }

    @PostMapping("/update")
    public ResponseResult delete(@RequestBody AdSensitive wmSensitiveDto){
        return wmSensitiveService.update(wmSensitiveDto);
    }


    @PostMapping("/save")
    public ResponseResult save(@RequestBody AdSensitive wmSensitiveDto){
        return wmSensitiveService.insert(wmSensitiveDto);
    }

}

