package cn.aesec.gaokaomanager.modules.gaokao.controller;

import cn.aesec.gaokaomanager.modules.common.api.BaseController;
import cn.aesec.gaokaomanager.modules.gaokao.entity.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import cn.aesec.gaokaomanager.modules.common.dto.output.ApiResult;
import cn.aesec.gaokaomanager.modules.gaokao.entity.CarouselMessageInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.CarouselMessageInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.service.CarouselMessageInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p>  接口 </p>
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-08-04 09:28:11
 *
 */
@RestController
@RequestMapping("/api/carouselMessageInfo")
@Api(description = "接口")
public class CarouselMessageInfoController extends BaseController {

    @Autowired
    CarouselMessageInfoService carouselMessageInfoService;

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody CarouselMessageInfoInput filter) {
        Page<CarouselMessageInfo> page = new Page<>(filter.getPage(),filter.getLimit());
        carouselMessageInfoService.listPage(page, filter);
        return ApiResult.ok("获取列表分页成功", page);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取列表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult list(@RequestBody CarouselMessageInfoInput filter) {
        List<CarouselMessageInfo> result = carouselMessageInfoService.list(filter);
        return ApiResult.ok("获取列表成功",result);
    }

    @PostMapping(value = "/changeStatus", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "改变发布状态", httpMethod = "POST", response = ApiResult.class)
    public ApiResult changeStatus(@RequestBody CarouselMessageInfo input) {
        Integer id = carouselMessageInfoService.save(input);
        return ApiResult.ok(input.getStatus() == 1 ? "显示" : "不显示", id);
    }

    @PostMapping(value = "/saveOrUpdate", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存", httpMethod = "POST", response = ApiResult.class)
    public ApiResult save(@RequestBody CarouselMessageInfo input) {
        Integer id = carouselMessageInfoService.save(input);
        return ApiResult.ok("保存成功", id);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody CarouselMessageInfoInput input) {
        carouselMessageInfoService.deleteById(input.getId());
        return ApiResult.ok("删除成功");
    }

    @PostMapping(value = "/getById", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取信息", httpMethod = "POST", response = ApiResult.class)
    public ApiResult getById(@RequestBody CarouselMessageInfoInput input) {
        CarouselMessageInfo entity = carouselMessageInfoService.selectById(input.getId());
        return ApiResult.ok("获取信息成功", entity);
    }

}