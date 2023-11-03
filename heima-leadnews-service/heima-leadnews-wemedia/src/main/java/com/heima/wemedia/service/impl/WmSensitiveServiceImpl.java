package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.admin.dtos.AdSensitive;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;
import com.heima.wemedia.mapper.WmSensitiveMapper;
import com.heima.wemedia.service.WmSensitiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@Service
public class WmSensitiveServiceImpl extends ServiceImpl<WmSensitiveMapper,WmSensitive> implements WmSensitiveService {


     @Autowired
     private WmSensitiveMapper wmSensitiveMapper;



    /**
     * 敏感词列表查询
     * @param dto
     * @return
     */
    @Override
    public ResponseResult list(SensitiveDto dto) {


        //1.检查参数
        dto.checkParam();

        //2.分页查询
        IPage page = new Page(dto.getPage(),dto.getSize());
        LambdaQueryWrapper<WmSensitive> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(dto.getName().isEmpty() == false,WmSensitive::getSensitives,dto.getName());

        //按照时间倒序
        lambdaQueryWrapper.orderByDesc(WmSensitive::getCreatedTime);

        page = page(page,lambdaQueryWrapper);

        //3.结果返回
        ResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(),(int)page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;

    }

    /**
     * 根据id删除敏感词
     * @param id
     * @return
     */
    @Override
    public ResponseResult delete(int id) {
        wmSensitiveMapper.deleteById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 保存敏感词信息
     * @param wmsensitiveDto
     * @return
     */
    @Override
    public ResponseResult update(AdSensitive wmsensitiveDto) {
        WmSensitive wmSensitive = new WmSensitive();
        BeanUtils.copyProperties(wmsensitiveDto,wmSensitive);
        wmSensitiveMapper.updateById(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult insert(AdSensitive wmsensitiveDto) {
        WmSensitive wmSensitive = new WmSensitive();
        BeanUtils.copyProperties(wmsensitiveDto,wmSensitive);
        wmSensitive.setCreatedTime(Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault()).toInstant()));

        HashMap<String,Object> map = new HashMap();
        map.put("sensitives",wmSensitive.getSensitives());
        if(wmSensitiveMapper.selectByMap(map).isEmpty() == false){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }

        wmSensitiveMapper.insert(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
