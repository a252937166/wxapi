package com.ouyang.controller;


import com.ouyang.model.UploadImageInfo;
import com.ouyang.model.VisitUserInfo;
import com.ouyang.service.UploadImageInfoService;
import com.ouyang.service.VisitUserInfoService;
import com.ouyang.util.*;
import com.ouyang.util.baidu.BaiduAiUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    VisitUserInfoService visitUserInfoService;
    @Autowired
    UploadImageInfoService uploadImageInfoService;

    @RequestMapping(value = "/uploadImg")
    public String uploadImg(MultipartFile file) {
        return QiniuUtil.uploadImg(file);
    }

    /**
     * 人脸识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     */
    @RequestMapping(value = "/baiDuFaceRecognize")
    public Object baiDuFaceRecognize(MultipartFile file,String userInfoId) throws IOException, JSONException {
        saveImageInfo(file,userInfoId);
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject faceJson = new JSONObject(BaiduAiUtil.faceRecognize(file.getBytes()));
        JSONArray resultArray = (JSONArray) faceJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * 人脸识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/tencentDetectFace")
    public Object tencentDetectFace(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        String uploadImageId = UUIDUtil.getId();
        String key = QiniuUtil.uploadImg(file);
        String imgUrl = QiniuUtil.getImgUrl(key);
        saveImageInfo(imgUrl,userInfoId);
        JSONObject faceJson = new JSONObject(TencentAiUtil.detectFace(imgUrl));
        JSONArray resultArray = (JSONArray) faceJson.get("face");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        jsonResult.put("imageInfoId",uploadImageId);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * 菜品识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/baiduDish")
    public Object baiduDish(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);
        JSONObject dishJson = new JSONObject(BaiduAiUtil.dish(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("菜品图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * 百度汽车识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/baiduCar")
    public Object baiduCar(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);
        JSONObject dishJson = new JSONObject(BaiduAiUtil.car(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("汽车图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * 植物识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/baiduPlant")
    public Object baiduPlant(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);
        JSONObject dishJson = new JSONObject(BaiduAiUtil.plant(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("植物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * 动物识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/baiduAnimal")
    public Object baiduAnimal(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);
        JSONObject dishJson = new JSONObject(BaiduAiUtil.animal(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("动物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }

    /**
     * Logo识别
     * @param file
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @RequestMapping(value = "/baiduLogo")
    public Object baiduLogo(MultipartFile file,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);
        JSONObject dishJson = new JSONObject(BaiduAiUtil.logo(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("动物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        httpResult.setResult(jsonResult.toString());
        return httpResult;
    }


    @RequestMapping(value = "/baiduOcr")
    public Object baiduOcr(MultipartFile file,Integer ocrtype,String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult httpResult = new HttpResult<>();
        saveImageInfo(file,userInfoId);

        switch (ocrtype) {
            case 0:
                httpResult.setResult(BaiduAiUtil.orcGeneralBasic(file.getBytes()).toString());
                break;
            case 7:
                JSONObject bankcardJson = new JSONObject(BaiduAiUtil.orcBankcard(file.getBytes()));
                if (!bankcardJson.has("result")) {
                    httpResult.setSuccess(false);
                    httpResult.setMsg("郭大队不觉得这是一张银行卡！");
                    return httpResult;
                }
                httpResult.setResult(bankcardJson.get("result").toString());
                break;
            default:
                break;
        }

        return httpResult;
    }


    @PostMapping("/saveUserInfo")
    public Object saveUserInfo(@RequestBody VisitUserInfo userInfo) {
        userInfo.setCreateDate(new Date());
        userInfo.setId(UUIDUtil.getId());
        HttpResult<VisitUserInfo> httpResult = new HttpResult<>();
        if (visitUserInfoService.add(userInfo) < 0) {
            httpResult.setMsg("添加失败！");
            httpResult.setSuccess(false);
            return httpResult;
        }
        httpResult.setResult(userInfo);
        return httpResult;
    }





    private void saveImageInfo(MultipartFile file,String userInfoId) {
        ThreadPoolUtils.run(() -> {
            String url = QiniuUtil.getImgUrl(QiniuUtil.uploadImg(file));
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            uploadImageInfo.setUserInfoId(userInfoId);
            uploadImageInfo.setUrl(url);
            uploadImageInfo.setCreateDate(new Date());
            uploadImageInfoService.add(uploadImageInfo);
        });
    }

    private void saveImageInfo(String imageUrl,String userInfoId) {
        ThreadPoolUtils.run(() -> {
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            uploadImageInfo.setUserInfoId(userInfoId);
            uploadImageInfo.setUrl(imageUrl);
            uploadImageInfo.setCreateDate(new Date());
            uploadImageInfoService.add(uploadImageInfo);
        });
    }

}
