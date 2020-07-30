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
 * <p>  用户基本信息表 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:13:41
 */
@Data
@ApiModel(description = "用户基本信息表")
@TableName("a_user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@ApiModelProperty(value = "用户id")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 手机号，目前通过手机号+验证码登录
     */
	@ApiModelProperty(value = "手机号，目前通过手机号+验证码登录")
	@TableField("phone_num")
	private String phoneNum;
    /**
     * 用户名
     */
	@ApiModelProperty(value = "用户名")
	@TableField("username")
	private String username;
    /**
     * 密码
     */
	@ApiModelProperty(value = "密码")
	@TableField("password")
	private String password;
    /**
     * 用户角色 1普通用户  2专家
     */
	@ApiModelProperty(value = "用户角色 1普通用户  2专家")
	@TableField("role")
	private Integer role;
    /**
     * 性别 1男  2女 0未知
     */
	@ApiModelProperty(value = "性别 1男  2女 0未知")
	@TableField("sex")
	private Integer sex;
    /**
     * 年龄
     */
	@ApiModelProperty(value = "年龄")
	@TableField("age")
	private Integer age;
    /**
     * 真实姓名
     */
	@ApiModelProperty(value = "真实姓名")
	@TableField("realname")
	private String realname;
    /**
     * 当前状态 1正常 0禁用
     */
	@ApiModelProperty(value = "当前状态 1正常 0禁用")
	@TableField("status")
	private Integer status;
    /**
     * 是否购买了vip，1是 0否
     */
	@ApiModelProperty(value = "是否购买了vip，1是 0否")
	@TableField("buy_vip")
	private Integer buyVip;
    /**
     * 是否购买了专家一对一，0否  1基础版  2高级版  3白金版
     */
	@ApiModelProperty(value = "是否购买了专家一对一，0否  1基础版  2高级版  3白金版")
	@TableField("buy_expert")
	private Integer buyExpert;
    /**
     * 最后一次登录时间
     */
	@ApiModelProperty(value = "最后一次登录时间")
	@TableField("last_login_time")
	private Date lastLoginTime;
    /**
     * 微信同一个开发者帐号多个应用之间UnionID相同
     */
	@ApiModelProperty(value = "微信同一个开发者帐号多个应用之间UnionID相同")
	@TableField("wx_union_id")
	private String wxUnionId;
    /**
     * 头像
     */
	@ApiModelProperty(value = "头像")
	@TableField("head_image")
	private String headImage;
    /**
     * 高考年份
     */
	@ApiModelProperty(value = "高考年份")
	@TableField("gk_year")
	private Integer gkYear;
    /**
     * 高考省份
     */
	@ApiModelProperty(value = "高考省份")
	@TableField("gk_province_id")
	private Integer gkProvinceId;
    /**
     * 高考分数
     */
	@ApiModelProperty(value = "高考分数")
	@TableField("gk_score")
	private Integer gkScore;
    /**
     * 文理科：1文科  2理科
     */
	@ApiModelProperty(value = "文理科：1文科  2理科")
	@TableField("gk_subject")
	private Integer gkSubject;
    /**
     * 每一科的分数
     */
	@ApiModelProperty(value = "每一科的分数")
	@TableField("gk_per_score")
	private String gkPerScore;
    /**
     * 用户当前的sessionId，用于实现单一设备登录
     */
	@ApiModelProperty(value = "用户当前的sessionId，用于实现单一设备登录")
	@TableField("current_session_id")
	private String currentSessionId;
    /**
     * 用户当前的deviceId，用于实现单一设备登录
     */
	@ApiModelProperty(value = "用户当前的deviceId，用于实现单一设备登录")
	@TableField("current_device_id")
	private String currentDeviceId;
    /**
     * 测评分数，地址栏参数
     */
	@ApiModelProperty(value = "测评分数，地址栏参数")
	@TableField("evaluation_score")
	private String evaluationScore;
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
