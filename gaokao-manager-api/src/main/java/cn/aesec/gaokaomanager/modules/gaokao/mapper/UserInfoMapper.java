package cn.aesec.gaokaomanager.modules.gaokao.mapper;

import cn.aesec.gaokaomanager.modules.gaokao.entity.UserInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.UserInfoInput;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 用户基本信息表 Mapper 接口 </p>
 *
 * @author : zhengqing
 * @date : 2020-07-30 10:13:41
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<UserInfo> selectUserInfos(Pagination page, @Param("filter") UserInfoInput filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<UserInfo> selectUserInfos(@Param("filter") UserInfoInput filter);
}