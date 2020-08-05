package cn.aesec.gaokaomanager.modules.gaokao.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import cn.aesec.gaokaomanager.modules.gaokao.entity.CarouselMessageInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.CarouselMessageInfoInput;

import java.util.List;

/**
 * <p>   服务类 </p>
 *
 * @author: zhengqing
 * @date: 2020-08-04 09:28:11
 */
public interface CarouselMessageInfoService extends IService<CarouselMessageInfo> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<CarouselMessageInfo> page, CarouselMessageInfoInput filter);

    /**
     * 保存
     *
     * @param input
     */
    Integer save(CarouselMessageInfo input);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<CarouselMessageInfo> list(CarouselMessageInfoInput filter);
}
