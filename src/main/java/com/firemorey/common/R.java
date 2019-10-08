package com.firemorey.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;


/**
 * 通用的json返回数据
 */
@ApiModel(value = "统一返回接口对象")
@Data
public class R<T> implements Serializable {

  private static final long serialVersionUID = -3477609529314194539L;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "目标结果", name = "data")
  private T data;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "消息", name = "msg")
  private String msg;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @ApiModelProperty(value = "状态码", name = "code")
  private Integer code;


  /**
   * 返回成功提示 返回请求数据
   *
   * @param jsonEnum enums
   * @param data     target value
   */
  public R(Msg jsonEnum, T data) {
    this.msg = jsonEnum.getDesc();
    this.code = jsonEnum.getStatusCode();
    this.data = data;
  }


  /**
   * 返回成功或者错误提示 不返回其他数据
   *
   * @param jsonEnum enums
   */
  public R(Msg jsonEnum) {
    super();
    this.code = jsonEnum.getStatusCode();
    this.msg = jsonEnum.getDesc();
    this.data = null;
  }
}
