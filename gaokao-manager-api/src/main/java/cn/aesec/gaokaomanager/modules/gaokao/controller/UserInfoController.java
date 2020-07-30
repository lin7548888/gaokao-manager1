package cn.aesec.gaokaomanager.modules.gaokao.controller;

import cn.aesec.gaokaomanager.modules.common.api.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import cn.aesec.gaokaomanager.modules.common.dto.output.ApiResult;
import cn.aesec.gaokaomanager.modules.gaokao.entity.UserInfo;
import cn.aesec.gaokaomanager.modules.gaokao.dto.input.UserInfoInput;
import cn.aesec.gaokaomanager.modules.gaokao.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p> 用户基本信息表 接口 </p>
 *
 * @author: zhengqing
 * @description:
 * @date: 2020-07-30 10:13:41
 *
 */
@RestController
@RequestMapping("/api/userInfo")
@Api(description = "用户基本信息表接口")
public class UserInfoController extends BaseController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取用户基本信息表列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody UserInfoInput filter) {
        Page<UserInfo> page = new Page<>(filter.getPage(),filter.getLimit());
        userInfoService.listPage(page, filter);
        return ApiResult.ok("获取用户基本信息表列表分页成功", page);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取用户基本信息表列表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult list(@RequestBody UserInfoInput filter) {
        List<UserInfo> result = userInfoService.list(filter);
        return ApiResult.ok("获取用户基本信息表列表成功",result);
    }

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存用户基本信息表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult save(@RequestBody UserInfo input) {
        Integer id = userInfoService.save(input);
        return ApiResult.ok("保存用户基本信息表成功", id);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除用户基本信息表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody UserInfoInput input) {
        userInfoService.deleteById(input.getId());
        return ApiResult.ok("删除用户基本信息表成功");
    }

    @PostMapping(value = "/getById", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取用户基本信息表信息", httpMethod = "POST", response = ApiResult.class)
    public ApiResult getById(@RequestBody UserInfoInput input) {
        UserInfo entity = userInfoService.selectById(input.getId());
        return ApiResult.ok("获取用户基本信息表信息成功", entity);
    }

}