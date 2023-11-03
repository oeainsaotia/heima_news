package com.heima.wemedia.controller.v1;

import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.admin.dtos.AdChannel;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class WmchannelController {

    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/channels")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }

    @PostMapping("/list")
    public ResponseResult list(@RequestBody ChannelDto dto){
        return wmChannelService.list(dto);
    }

    @GetMapping("/del/{id}")
    public ResponseResult delete(@PathVariable int id){
        return wmChannelService.delete(id);
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody AdChannel dto){
        return wmChannelService.save(dto);
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody AdChannel dto){
        return wmChannelService.update(dto);
    }

}


