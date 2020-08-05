package cn.aesec.gaokaomanager.modules.gaokao.dto.input;

import cn.aesec.gaokaomanager.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * APP信息表查询参数
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-07-30 10:12:09
 */
@Data
@ApiModel(description = "APP信息表查询参数")
public class AppInfoInput extends BasePageQuery{
    @ApiModelProperty(value = "id")
    private Long id;
}
