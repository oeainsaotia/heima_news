package com.heima.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 频道引用表
 */
@Data
@TableName("ad_channel_label")
public class AdChannelLabel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 频道id
     */
    @TableField("channel_id")
    private Integer channelId;

    /**
     * labelId
     */
    @TableField("label_id")
    private Integer labelId;

    /**
     * Ord
     */
    @TableField("ord")
    private Integer ord;

}
