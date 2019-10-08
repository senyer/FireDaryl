package com.firemorey.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageVo implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页号",example = "1")
    private int pageNum = 1;

    @ApiModelProperty(value = "页面大小",example = "20")
    private int pageSize = 20;

    @ApiModelProperty(value = "排序字段",example = "id")
    private String sort = "id";

    @ApiModelProperty(value = "排序方式 asc/desc",example = "desc")
    private String order = "asc";
}
