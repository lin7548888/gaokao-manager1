package cn.aesec.gaokaomanager.modules.gaokao.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**

 * <p>  全局变量表 </p>

   *

 * @author: zhengqing

 * @date: 2020-07-30 17:48:09
   */
      @Data
   @ApiModel(description = "全局变量表")
   @TableName("a_global_config")
         public class Banner extends Model<Banner> {
   
   private static final long serialVersionUID = 1L;

    /**
     * 键
     */
	@ApiModelProperty(value = "键")
	@TableId(value="config_key", type= IdType.ID_WORKER)
	private String configKey;
    /**
     * 值
     */
	@ApiModelProperty(value = "值")
	@TableField("config_value")
	private String configValue;
    /**
     * 描述
     */
	@ApiModelProperty(value = "描述")
	@TableField("config_desc")
	private String configDesc;

	@Override
	protected Serializable pkVal() {
		return this.configKey;
	}

}