package cn.aesec.gaokaomanager.modules.gaokao.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import cn.aesec.gaokaomanager.modules.gaokao.entity.Banner;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.BannerInput;

import java.util.List;

/**
 * <p>  全局变量表 服务类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 17:53:23
 */
public interface BannerService extends IService<Banner> {

    /**
     * 全局变量表列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<Banner> page, BannerInput filter);


    /**
     * 全局变量表列表
     *
     * @param filter
     * @return
     */
    List<Banner> list(BannerInput filter);

    List<Banner> Banner();

}