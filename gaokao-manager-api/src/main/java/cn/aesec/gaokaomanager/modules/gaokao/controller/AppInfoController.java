package cn.aesec.gaokaomanager.modules.gaokao.controller;

import cn.aesec.gaokaomanager.modules.common.api.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

import com.baomidou.mybatisplus.plugins.Page;
import cn.aesec.gaokaomanager.modules.common.dto.output.ApiResult;
import cn.aesec.gaokaomanager.modules.gaokao.entity.AppInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.AppInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.service.AppInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p> APP信息表 接口 </p>
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-07-30 10:12:09
 *
 */
@RestController
@RequestMapping("/api/appInfo")
@Api(description = "APP信息表接口")
public class AppInfoController extends BaseController {

    @Autowired
    AppInfoService appInfoService;

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取APP信息表列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody AppInfoInput filter) {
        Page<AppInfo> page = new Page<>(filter.getPage(),filter.getLimit());
        appInfoService.listPage(page, filter);
        return ApiResult.ok("获取APP信息表列表分页成功", page);
    }

//    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
//    @ApiOperation(value = "获取APP信息表列表", httpMethod = "POST", response = ApiResult.class)
//    public ApiResult list(@RequestBody AppInfoInput filter) {
//        List<AppInfo> result = appInfoService.list(filter);
//        return ApiResult.ok("获取APP信息表列表成功",result);
//    }

    @PostMapping(value = "/saveOrUpdate", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存或更新APP信息表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult saveOrUpdate(@RequestBody AppInfo input) {
        Integer id = appInfoService.save(input);
        return ApiResult.ok("保存APP信息表成功", id);
    }

    @PostMapping(value = "/changeStatus", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "改变发布状态", httpMethod = "POST", response = ApiResult.class)
    public ApiResult changeStatus(@RequestBody AppInfo input) {
        Integer id = appInfoService.save(input);
        return ApiResult.ok(input.getStatus() == 1 ? "该版本已发布" : "该版本已取消发布", id);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除APP信息表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody AppInfoInput input) {
        appInfoService.deleteById(input.getId());
        return ApiResult.ok("删除APP信息表成功");
    }



}