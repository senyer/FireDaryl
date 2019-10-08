package com.firemorey.vo;

import com.firemorey.domain.Patriot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="PatriotDeatilVO" ,description = "详细版用户信息")
public class PatrioDetailVO extends Patriot {

}
