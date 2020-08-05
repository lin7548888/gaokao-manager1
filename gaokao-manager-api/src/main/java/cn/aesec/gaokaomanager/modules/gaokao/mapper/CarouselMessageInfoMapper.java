package cn.aesec.gaokaomanager.modules.gaokao.mapper;

import cn.aesec.gaokaomanager.modules.gaokao.entity.CarouselMessageInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.CarouselMessageInfoInput;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>  Mapper 接口 </p>
 *
 * @author : zhengqing
 * @date : 2020-08-04 09:28:11
 */
public interface CarouselMessageInfoMapper extends BaseMapper<CarouselMessageInfo> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<CarouselMessageInfo> selectCarouselMessageInfos(Pagination page, @Param("filter") CarouselMessageInfoInput filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<CarouselMessageInfo> selectCarouselMessageInfos(@Param("filter") CarouselMessageInfoInput filter);
}