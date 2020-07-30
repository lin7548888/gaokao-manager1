package cn.aesec.gaokaomanager.modules.gaokao.dto.input;

import cn.aesec.gaokaomanager.modules.common.dto.input.BasePageQuery;
import cn.aesec.gaokaomanager.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户基本信息表查询参数
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-07-30 10:13:41
 */
@Data
@ApiModel(description = "用户基本信息表查询参数")
public class UserInfoInput extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private int id;
}
