package cn.aesec.gaokaomanager.modules.gaokao.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import cn.aesec.gaokaomanager.modules.gaokao.entity.UserInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.UserInfoInput;

import java.util.List;

/**
 * <p>  用户基本信息表 服务类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:13:41
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 用户基本信息表列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<UserInfo> page, UserInfoInput filter);

    /**
     * 保存用户基本信息表
     *
     * @param input
     */
    Integer save(UserInfo input);

    /**
     * 用户基本信息表列表
     *
     * @param filter
     * @return
     */
    List<UserInfo> list(UserInfoInput filter);
}
