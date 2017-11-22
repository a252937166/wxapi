package com.ouyang.controller;



import com.ouyang.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/api")
public class ApiController {
    @ResponseBody
    @RequestMapping(value = "/uploadImg")
    public String uploadImg(MultipartFile file) {
        return QiniuUtil.uploadImg(file);
    }

    @RequestMapping(value = "/baiDuFaceRecognize")
    public Object baiDuFaceRecognize(MultipartFile file) throws IOException, JSONException {
        ThreadPoolUtils.run(new Runnable() {
            @Override
            public void run() {
                QiniuUtil.uploadImg(file);
            }
        });
        HttpResult<String> httpResult = new HttpResult<>();
        JSONArray resultArray = (JSONArray) BaiduAiUtil.faceRecognize(file.getBytes()).get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    @RequestMapping(value = "/tencentDetectFace")
    public Object tencentDetectFace(MultipartFile file) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<String> httpResult = new HttpResult<>();
        String key = QiniuUtil.uploadImg(file);
        String imgUrl = QiniuUtil.getImgUrl(key);
        JSONArray resultArray = (JSONArray) TencentAiUtil.detectFace(imgUrl).get("face");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

}
