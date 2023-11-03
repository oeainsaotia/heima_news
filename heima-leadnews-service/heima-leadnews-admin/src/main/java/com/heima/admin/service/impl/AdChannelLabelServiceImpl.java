package com.heima.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdChannelLabelMapper;
import com.heima.admin.service.AdChannelLabelService;
import com.heima.model.admin.dtos.SelectByChannelIdDto;
import com.heima.model.admin.pojos.AdChannelLabel;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdChannelLabelServiceImpl extends ServiceImpl<AdChannelLabelMapper, AdChannelLabel> implements AdChannelLabelService {

    @Autowired
    private AdChannelLabelMapper adChannelLabelMapper;


    /**
     * 根据channel_id查询数据
     * @param dto
     * @return
     */
    @Override
    public ResponseResult selectByChannelId(SelectByChannelIdDto dto) {

        AdChannelLabel adChannelLabel = new AdChannelLabel();
        HashMap<String, Object> map = new HashMap();
        adChannelLabel.setChannelId(dto.getChannelId());
        map.put("channel_id", adChannelLabel.getChannelId());
//        List<AdChannelLabel> list = adChannelLabelMapper.selectByMap(map);
        return ResponseResult.okResult(adChannelLabelMapper.selectByMap(map));
    }
}
