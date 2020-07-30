package cn.aesec.gaokaomanager.modules.gaokao.controller;

import cn.aesec.gaokaomanager.modules.common.dto.output.ApiResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class UploadController {
    @Value("${custom.uploadBaseDir}")
    private String uploadBaseDir;
    @Value("${custom.uploadBaseUrl}")
    private String uploadBaseUrl;

    @PostMapping(value = "/uploadFile", produces = "application/json;charset=utf-8")
    public ApiResult uploadFile(@RequestParam(value = "file") MultipartFile file) {
        String targetName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            file.transferTo(new File(uploadBaseDir + targetName));
        } catch (Exception e) {

        }
        Map map = new HashMap(8);
        map.put("fileUrl", uploadBaseUrl + targetName);
        return ApiResult.ok("文件上传成功", map);
    }
}
