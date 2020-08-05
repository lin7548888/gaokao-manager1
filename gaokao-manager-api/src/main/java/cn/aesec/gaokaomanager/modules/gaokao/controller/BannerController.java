package cn.aesec.gaokaomanager.modules.gaokao.controller;

import cn.aesec.gaokaomanager.modules.common.api.BaseController;
import cn.aesec.gaokaomanager.modules.gaokao.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import cn.aesec.gaokaomanager.modules.common.dto.output.ApiResult;
import cn.aesec.gaokaomanager.modules.gaokao.entity.Banner;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.BannerInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**

 * <p> 全局变量表 接口 </p>

   *

 * @author: zhengqing

 * @description:

 * @date: 2020-07-30 17:40:18
   *
    */
   @RestController
   @RequestMapping("/api/banner")
   @Api(description = "全局变量表接口")
   public class BannerController extends BaseController {

    @Autowired
    BannerService globalConfigService;

//    @PostMapping(value = "/getBanner", produces = "application/json;charset=utf-8")
//    @ApiOperation(value = "获取轮播图", httpMethod = "POST", response = ApiResult.class)
//    public ApiResult getBanner(@RequestBody BannerInput filter) {
//        Page<Banner> page = new Page<>(filter.getPage(), filter.getLimit());
//        globalConfigService.Banner();
//        return ApiResult.ok("获取轮播图成功", page);
//    }

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取全局变量表列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody BannerInput filter) {
        Page<Banner> page = new Page<>(filter.getPage(), filter.getLimit());
        globalConfigService.listPage(page, filter);
        return ApiResult.ok("获取全局变量表列表分页成功", page);
    }

//    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
//    @ApiOperation(value = "获取全局变量表列表", httpMethod = "POST", response = ApiResult.class)
//    public ApiResult list(@RequestBody BannerInput filter) {
//        List<Banner> result = globalConfigService.list(filter);
//        return ApiResult.ok("获取全局变量表列表成功", result);
//    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除全局变量表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody BannerInput input) {
        globalConfigService.deleteById(input.getConfigKey());
        return ApiResult.ok("删除全局变量表成功");
    }

    @PostMapping(value = "/getById", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取全局变量表信息", httpMethod = "POST", response = ApiResult.class)
    public ApiResult getById(@RequestBody BannerInput input) {
        Banner entity = globalConfigService.selectById(input.getConfigKey());
        return ApiResult.ok("获取全局变量表信息成功", entity);

    }
}

