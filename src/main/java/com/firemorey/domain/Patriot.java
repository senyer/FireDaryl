package com.firemorey.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gardener
 * @since 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Patriot对象", description="")
public class Patriot extends Model<Patriot> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "签名图片",example = "")
    @TableField("signed_picture")
    private String signedPicture;

    @ApiModelProperty(value = "终端设备",example = "")
    @TableField("terminal_device")
    private String terminalDevice;

    @ApiModelProperty(value = "代理商",example = "")
    @TableField("user_agent")
    private String userAgent;

    @ApiModelProperty(value = "ip地址",example = "")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "用户位置等",example = "")
    @TableField("ip_info")
    private String ipInfo;

    @ApiModelProperty(value = "用户名",example = "")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "用户签名时间",example = "")
    @TableField("time")
    private LocalDateTime time;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
