package cn.aesec.gaokaomanager.modules.gaokao.mapper;

import cn.aesec.gaokaomanager.modules.gaokao.entity.AppInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.AppInfoInput;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> APP信息表 Mapper 接口 </p>
 *
 * @author : zhengqing
 * @date : 2020-07-30 10:12:09
 */
public interface AppInfoMapper extends BaseMapper<AppInfo> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<AppInfo> selectAppInfos(Pagination page, @Param("filter") AppInfoInput filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<AppInfo> selectAppInfos(@Param("filter") AppInfoInput filter);
}