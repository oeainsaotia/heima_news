package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.apis.admin.IAdminClient;
import com.heima.model.admin.dtos.SelectByChannelIdDto;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.admin.dtos.AdChannel;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.wemedia.mapper.WmChannelMapper;
import com.heima.wemedia.service.WmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements WmChannelService {

    @Autowired
    private WmChannelMapper wmChannelMapper;

    @Autowired
    private IAdminClient iAdminClient;



    /**
     * 查询所有频道
     * @return
     */
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(list());
    }

    @Override
    public ResponseResult list(ChannelDto dto) {

        //1.检查参数
        dto.checkParam();

        //2.分页查询
        IPage page = new Page(dto.getPage(),dto.getSize());
        LambdaQueryWrapper<WmChannel> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(dto.getName().isEmpty() == false,WmChannel::getName,dto.getName());

        //按照Ord排序
        lambdaQueryWrapper.orderByDesc(WmChannel::getOrd);

        page = page(page,lambdaQueryWrapper);

        //3.结果返回
        ResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(),(int)page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;
    }

    /**
     * 根据id删除频道
     * @param id
     * @return
     */
    @Override
    public ResponseResult delete(int id) {
        if(wmChannelMapper.selectById(id).getStatus()){
            return ResponseResult.errorResult(AppHttpCodeEnum.NOTDISABLE);
        }
        wmChannelMapper.deleteById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult save(AdChannel dto) {
        WmChannel wmChannel = new WmChannel();
        BeanUtils.copyProperties(dto,wmChannel);
        wmChannel.setCreatedTime(Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant()));

        HashMap<String,Object> map = new HashMap();
        map.put("name",wmChannel.getName());
        if(wmChannelMapper.selectByMap(map).isEmpty() == false){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        } else if (wmChannel.getOrd() == null) {
            wmChannel.setOrd(0);
        }

        wmChannel.setIsDefault(true);

        wmChannelMapper.insert(wmChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult update(AdChannel dto) {
        WmChannel wmChannel = new WmChannel();
        BeanUtils.copyProperties(dto,wmChannel);

        SelectByChannelIdDto selectByChannelIdDto = new SelectByChannelIdDto();
        selectByChannelIdDto.setChannelId(dto.getId());

        ResponseResult responseResult = iAdminClient.channel_id(selectByChannelIdDto);

        System.out.println(responseResult.getData().toString());
        if(responseResult.getData().toString() != "[]"){
            return ResponseResult.errorResult(AppHttpCodeEnum.USED);
        }

        wmChannelMapper.updateById(wmChannel);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);

    }

}
