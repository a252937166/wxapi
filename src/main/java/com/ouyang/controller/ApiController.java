package com.ouyang.controller;



import com.ouyang.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/api")
public class ApiController {
    @ResponseBody
    @RequestMapping(value = "/uploadImg")
    public String uploadImg(MultipartFile file) {
        return QiniuUtil.uploadImg(file);
    }

}
