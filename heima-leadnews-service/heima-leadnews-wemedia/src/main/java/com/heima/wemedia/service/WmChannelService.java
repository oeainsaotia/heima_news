package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.admin.dtos.AdChannel;
import com.heima.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    /**
     * 查询所有频道
     * @return
     */
    ResponseResult findAll();

    /**
     * 分页查询频道
     * @param dto
     * @return
     */
    ResponseResult list(ChannelDto dto);

    /**
     * 根据id删除频道
     * @param id
     * @return
     */
    ResponseResult delete(int id);


    /**
     * 保存频道信息
     * @param dto
     * @return
     */
    ResponseResult save(AdChannel dto);

    /**
     * 更新频道信息
     * @param dto
     * @return
     */
    ResponseResult update(AdChannel dto);
}
