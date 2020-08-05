package cn.aesec.gaokaomanager.modules.gaokao.entity;

import java.util.Date;
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
 * <p>   </p>
 *
 * @author: zhengqing
 * @date: 2020-08-04 09:28:11
 */
@Data
@ApiModel(description = "")
@TableName("a_carousel_message_info")
public class CarouselMessageInfo extends Model<CarouselMessageInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
	@ApiModelProperty(value = "消息id")
	@TableId(value="id", type= IdType.ID_WORKER)
	private Long id;
    /**
     * 订单id
     */
	@ApiModelProperty(value = "订单id")
	@TableField("order_id")
	private Long orderId;
    /**
     * 消息内容
     */
	@ApiModelProperty(value = "消息内容")
	@TableField("message")
	private String message;
    /**
     * 消息类别
     */
	@ApiModelProperty(value = "消息类别")
	@TableField("type")
	private Integer type;
    /**
     * 状态，0不显示消息，1显示消息
     */
	@ApiModelProperty(value = "状态，0不显示消息，1显示消息")
	@TableField("status")
	private Integer status;
    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
	@TableField("c_time")
	private Date cTime;
    /**
     * 创建人
     */
	@ApiModelProperty(value = "创建人")
	@TableField("c_user_id")
	private Long cUserId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
