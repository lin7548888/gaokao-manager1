
package cn.aesec.gaokaomanager.modules.gaokao.service.impl;

import cn.aesec.gaokaomanager.modules.gaokao.entity.AppInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.AppInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.mapper.AppInfoMapper;
import cn.aesec.gaokaomanager.modules.gaokao.service.AppInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> APP信息表 服务实现类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 10:12:09
 */
@Service
@Transactional
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {

    @Autowired
    AppInfoMapper appInfoMapper;

    @Override
    public void listPage(Page<AppInfo> page, AppInfoInput filter) {
        page.setRecords(appInfoMapper.selectAppInfos(page, filter));
    }

    @Override
    public List<AppInfo> list(AppInfoInput filter) {
        return appInfoMapper.selectAppInfos(filter);
    }

    @Override
    public Integer save(AppInfo para) {
        if (para.getId()!=null) {
           return appInfoMapper.updateById(para);
        } else {
           return appInfoMapper.insert(para);
        }
    }
}

 