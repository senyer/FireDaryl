package com.firemorey.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="PatriotForm",description="用户签名表单")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class PatriotForm {
}
