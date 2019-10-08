package com.firemorey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="PatriotVO" ,description = "")
public class PatrioVO {

  @ApiModelProperty(value = "签名图片",example = "")
  private String signedPicture;

  @ApiModelProperty(value = "用户名",example = "")
  private String userName;

}
