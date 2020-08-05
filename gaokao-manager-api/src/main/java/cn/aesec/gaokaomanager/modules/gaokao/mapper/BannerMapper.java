package cn.aesec.gaokaomanager.modules.gaokao.mapper;

import cn.aesec.gaokaomanager.modules.gaokao.entity.Banner;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.BannerInput;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 全局变量表 Mapper 接口 </p>
 *
 * @author : zhengqing
 * @date : 2020-07-30 17:40:18
 */
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<Banner> selectGlobalConfigs(Pagination page, @Param("filter") BannerInput filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<Banner> selectGlobalConfigs(@Param("filter") BannerInput filter);

    List<Banner> selectBanner();
}

