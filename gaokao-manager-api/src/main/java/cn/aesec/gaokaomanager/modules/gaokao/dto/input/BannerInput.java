package cn.aesec.gaokaomanager.modules.gaokao.dto.input;

import cn.aesec.gaokaomanager.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**

 * 全局变量表查询参数
   *
 * @author: zhengqing
 * @description:
 * @date: 2020-07-30 17:40:18
   */
   @Data
   @ApiModel(description = "全局变量表查询参数")
   public class BannerInput extends BasePageQuery{
   @ApiModelProperty(value = "configKey")
   private String configKey;
   }