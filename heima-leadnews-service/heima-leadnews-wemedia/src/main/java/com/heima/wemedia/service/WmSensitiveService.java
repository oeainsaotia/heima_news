package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.admin.dtos.AdSensitive;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;

public interface WmSensitiveService extends IService<WmSensitive> {

    /**
     * 分页查询敏感词
     * @param dto
     * @return
     */
    public ResponseResult list(SensitiveDto dto);

    /**
     * 删除敏感词信息
     * @param id
     * @return
     */
    public ResponseResult delete(int id);

    /**
     * 更新敏感词信息
     * @param wmsensitiveDto
     * @return
     */
    public ResponseResult update(AdSensitive wmsensitiveDto);

    /**
     * 保存敏感词信息
     * @param wmsensitiveDto
     * @return
     */
    public ResponseResult insert(AdSensitive wmsensitiveDto);



}
