package org.csu.travelbyex.controller;

import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.Result;
import org.csu.travelbyex.core.ResultGenerator;
import org.csu.travelbyex.domain.AccountInfo;
import org.csu.travelbyex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin

public class ImageController {

    @Autowired
    AccountService accountService;


    @ApiOperation(value = "上传用户头像")
    @PostMapping("/accountImages")
    public Result addDish(@RequestParam("photos") MultipartFile file, @RequestParam("accountId") String accountId) throws Exception
    {
        String path = "C:/Users/Stronger/Desktop/pic/213";// 文件路径
        if (file!=null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称


            // 判断文件类型
            type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;

                    // 文件夹不存在就创建
//                    File dir = new File(path);
//                    if  (!dir .exists()  && !dir .isDirectory())
//                        dir.mkdirs();

                        // 设置存放图片文件的路径
                    path += trueFileName;
                    //System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    //System.out.println("文件成功上传到指定目录下");

                    AccountInfo accountInfo = accountService.getAccountInfoByUserId(accountId);
                    accountInfo.setImagePath(path);
                    accountService.updateAccountInfo(accountInfo);


                    return ResultGenerator.success(path);
                }else{
                    return ResultGenerator.success("不是我们想要的文件类型,请按要求重新上传");
                }

            }else {
                //System.out.println("不是我们想要的文件类型,请按要求重新上传");
                return ResultGenerator.fail("文件类型为空");

            }
        }
        return ResultGenerator.fail("没找到相对应的文件");
    }
}
