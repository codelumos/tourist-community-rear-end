package org.csu.travel.controller;

import io.swagger.annotations.ApiOperation;
import org.csu.travel.core.Result;
import org.csu.travel.core.ResultGenerator;
import org.csu.travel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin

public class ImageController {

    @Autowired
    AccountService accountService;


    @ApiOperation(value = "拼途上传图片")
    @PostMapping("/images")
    public Result addDish(MultipartFile file) throws Exception {
        String path = "\\static\\img\\";// 文件路径
        if (file != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equalsIgnoreCase(type) || "PNG".equalsIgnoreCase(type) || "JPG".equalsIgnoreCase(type)) {
                    // 自定义的文件名称
                    String trueFileName = System.currentTimeMillis() + "." + type;
                    // 设置存放图片文件的路径
                    path += trueFileName;
                    String savePath = "/static/img/" + trueFileName;
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    return ResultGenerator.success(savePath);
                } else {
                    return ResultGenerator.success("不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                return ResultGenerator.fail("文件类型为空");
            }
        }
        return ResultGenerator.fail("没找到相对应的文件");
    }
}
