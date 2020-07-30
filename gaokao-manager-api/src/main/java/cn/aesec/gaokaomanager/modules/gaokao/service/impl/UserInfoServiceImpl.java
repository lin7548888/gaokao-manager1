
package cn.aesec.gaokaomanager.modules.gaokao.service.impl;

import cn.aesec.gaokaomanager.modules.gaokao.entity.UserInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.UserInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.mapper.UserInfoMapper;
import cn.aesec.gaokaomanager.modules.gaokao.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 用户基本信息表 服务实现类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:13:41
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public void listPage(Page<UserInfo> page, UserInfoInput filter) {
        page.setRecords(userInfoMapper.selectUserInfos(page, filter));
    }

    @Override
    public List<UserInfo> list(UserInfoInput filter) {
        return userInfoMapper.selectUserInfos(filter);
    }

    @Override
    public Integer save(UserInfo para) {
        if (para.getId()!=null) {
           return userInfoMapper.updateById(para);
        } else {
           return userInfoMapper.insert(para);
        }
    }
}

 