package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.dtos.SelectByChannelIdDto;
import com.heima.model.admin.pojos.AdChannelLabel;
import com.heima.model.common.dtos.ResponseResult;

public interface AdChannelLabelService extends IService<AdChannelLabel> {

    /**
     * 根据channel_id查询信息
     * @param dto
     * @return
     */
    ResponseResult selectByChannelId(SelectByChannelIdDto dto);
}
