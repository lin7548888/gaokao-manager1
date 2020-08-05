
package cn.aesec.gaokaomanager.modules.gaokao.service.impl;

import cn.aesec.gaokaomanager.modules.gaokao.entity.CarouselMessageInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.CarouselMessageInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.mapper.CarouselMessageInfoMapper;
import cn.aesec.gaokaomanager.modules.gaokao.service.CarouselMessageInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>  服务实现类 </p>
 *
 * @author: zhengqing
 * @date: 2020-08-04 09:28:11
 */
@Service
@Transactional
public class CarouselMessageInfoServiceImpl extends ServiceImpl<CarouselMessageInfoMapper, CarouselMessageInfo> implements CarouselMessageInfoService {

    @Autowired
    CarouselMessageInfoMapper carouselMessageInfoMapper;

    @Override
    public void listPage(Page<CarouselMessageInfo> page, CarouselMessageInfoInput filter) {
        page.setRecords(carouselMessageInfoMapper.selectCarouselMessageInfos(page, filter));
    }

    @Override
    public List<CarouselMessageInfo> list(CarouselMessageInfoInput filter) {
        return carouselMessageInfoMapper.selectCarouselMessageInfos(filter);
    }

    @Override
    public Integer save(CarouselMessageInfo para) {
        if (para.getId()!=null) {
           return carouselMessageInfoMapper.updateById(para);
        } else {
           return carouselMessageInfoMapper.insert(para);
        }

    }
}

 