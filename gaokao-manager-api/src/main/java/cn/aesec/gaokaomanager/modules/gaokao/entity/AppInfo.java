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
 * <p>  APP信息表 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:12:09
 */
@Data
@ApiModel(description = "APP信息表")
@TableName("a_app_info")
public class AppInfo extends Model<AppInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
	@ApiModelProperty(value = "流水号")
	@TableId(value="id", type= IdType.ID_WORKER)
	private Long id;
    /**
     * app类型，1android 2ios
     */
	@ApiModelProperty(value = "app类型，1android 2ios")
	@TableField("type")
	private Integer type;
    /**
     * 版本号
     */
	@ApiModelProperty(value = "版本号")
	@TableField("version")
	private String version;
    /**
     * 下载地址
     */
	@ApiModelProperty(value = "下载地址")
	@TableField("download_url")
	private String downloadUrl;
    /**
     * 更新日志，多条用|分隔
     */
	@ApiModelProperty(value = "更新日志，多条用|分隔")
	@TableField("update_log")
	private String updateLog;
    /**
     * 是否强制升级
     */
	@ApiModelProperty(value = "是否强制升级")
	@TableField("force_update")
	private Integer forceUpdate;
    /**
     * 当前状态 0删除 1正常
     */
	@ApiModelProperty(value = "当前状态 0删除 1正常")
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
    /**
     * 修改时间
     */
	@ApiModelProperty(value = "修改时间")
	@TableField("m_time")
	private Date mTime;
    /**
     * 修改人
     */
	@ApiModelProperty(value = "修改人")
	@TableField("m_user_id")
	private Long mUserId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
