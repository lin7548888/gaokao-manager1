package cn.aesec.gaokaomanager.modules.gaokao.dto.input;

import cn.aesec.gaokaomanager.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询参数
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-08-04 09:28:11
 */
@Data
@ApiModel(description = "查询参数")
public class CarouselMessageInfoInput extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private Long id;
}
