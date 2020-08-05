package cn.aesec.gaokaomanager.modules.gaokao.service.impl;

import cn.aesec.gaokaomanager.modules.gaokao.entity.Banner;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.BannerInput;
import cn.aesec.gaokaomanager.modules.gaokao.mapper.BannerMapper;
import cn.aesec.gaokaomanager.modules.gaokao.service.BannerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 全局变量表 服务实现类 </p>
 *
 * @author: zhengqing
 * @date: 2020-07-30 17:40:18
 */
@Service
@Transactional
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public void listPage(Page<Banner> page, BannerInput filter) {
        page.setRecords(bannerMapper.selectGlobalConfigs(page, filter));
    }

    @Override
    public List<Banner> list(BannerInput filter) {
        return bannerMapper.selectGlobalConfigs(filter);
    }

    @Override
    public List<Banner> Banner() {
        return bannerMapper.selectBanner();
    }
}

 