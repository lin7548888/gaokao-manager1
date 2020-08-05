package cn.aesec.gaokaomanager.modules.gaokao.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import cn.aesec.gaokaomanager.modules.gaokao.entity.AppInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.AppInfoInput;

import java.util.List;

/**
 * <p>  APP信息表 服务类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:12:09
 */
public interface AppInfoService extends IService<AppInfo> {

    /**
     * APP信息表列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<AppInfo> page, AppInfoInput filter);

    /**
     * 保存APP信息表
     *
     * @param input
     */
    Integer save(AppInfo input);

    /**
     * APP信息表列表
     *
     * @param filter
     * @return
     */
    List<AppInfo> list(AppInfoInput filter);
}
