package com.ouyang.controller;


import com.ouyang.constant.MyConstant;
import com.ouyang.model.UploadImageInfo;
import com.ouyang.model.VisitUserInfo;
import com.ouyang.service.UploadImageInfoService;
import com.ouyang.service.VisitUserInfoService;
import com.ouyang.util.*;
import com.ouyang.util.baidu.BaiduAiUtil;
import com.ouyang.util.baidu.HttpUtil;
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
;


@RestController
@RequestMapping("/api")
public class ApiController {
    private final VisitUserInfoService visitUserInfoService;
    private final UploadImageInfoService uploadImageInfoService;

    @Autowired
    public ApiController(VisitUserInfoService visitUserInfoService, UploadImageInfoService uploadImageInfoService) {
        this.visitUserInfoService = visitUserInfoService;
        this.uploadImageInfoService = uploadImageInfoService;
    }

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
    public HttpResult<Object> baiDuFaceRecognize(MultipartFile file, String userInfoId) throws IOException, JSONException {
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject faceJson = new JSONObject(BaiduAiUtil.faceRecognize(file.getBytes()));
        JSONArray resultArray = (JSONArray) ((JSONObject) faceJson.get("result")).get("face_list");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<Object> tencentDetectFace(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        String uploadImageId = UUIDUtil.getId();
        String key = QiniuUtil.uploadImg(file);
        String imgUrl = QiniuUtil.getImgUrl(key);
        JSONObject faceJson = new JSONObject(TencentAiUtil.detectFace(imgUrl));
        JSONArray resultArray = (JSONArray) faceJson.get("face");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("人物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        jsonResult.put("imageInfoId",uploadImageId);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<Object> baiduDish(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject dishJson = new JSONObject(BaiduAiUtil.dish(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("菜品图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<Object> baiduCar(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject dishJson = new JSONObject(BaiduAiUtil.car(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("汽车图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<Object> baiduPlant(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject dishJson = new JSONObject(BaiduAiUtil.plant(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("植物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<Object> baiduAnimal(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<Object> httpResult = new HttpResult<>();
        JSONObject dishJson = new JSONObject(BaiduAiUtil.animal(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("动物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
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
    public HttpResult<String> baiduLogo(MultipartFile file, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<String> httpResult = new HttpResult<>();
        JSONObject dishJson = new JSONObject(BaiduAiUtil.logo(file.getBytes()));
        JSONArray resultArray = (JSONArray) dishJson.get("result");
        if (resultArray.length() == 0) {
            httpResult.setSuccess(false);
            httpResult.setMsg("动物图像无法识别！");
            return httpResult;
        }
        JSONObject jsonResult = (JSONObject) resultArray.get(0);
        String resultStr = jsonResult.toString();
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
        return httpResult;
    }


    @RequestMapping(value = "/baiduOcr")
    public HttpResult<String> baiduOcr(MultipartFile file, Integer ocrtype, String userInfoId) throws IOException, JSONException, NoSuchAlgorithmException, KeyManagementException {
        HttpResult<String> httpResult = new HttpResult<>();
        String resultStr = "";
        switch (ocrtype) {
            case 0:
                resultStr = BaiduAiUtil.orcGeneralBasic(file.getBytes());
                break;
            case 7:
                JSONObject bankcardJson = new JSONObject(BaiduAiUtil.orcBankcard(file.getBytes()));
                if (!bankcardJson.has("result")) {
                    httpResult.setSuccess(false);
                    httpResult.setMsg("郭大队不觉得这是一张银行卡！");
                    return httpResult;
                }
                resultStr = bankcardJson.get("result").toString();
                break;
            default:
                break;
        }
        saveImageInfo(file.getOriginalFilename(),file.getBytes(),userInfoId,resultStr);
        httpResult.setResult(resultStr);
        return httpResult;
    }


    @PostMapping("/saveUserInfo")
    public HttpResult<VisitUserInfo> saveUserInfo(@RequestBody VisitUserInfo userInfo) throws Exception {
        userInfo.setCreateDate(new Date());
        userInfo.setId(UUIDUtil.getId());
        String url = MyConstant.WX_GET_OPENID_URL.replace("JSCODE", userInfo.getCode());
        String jsonStr = HttpUtil.getUrl(url,"application/json","UTF-8");
        JSONObject object = new JSONObject(jsonStr);
        String openid = (String) object.get("openid");
        String sessionKey = (String) object.get("session_key");
        userInfo.setOpenid(openid);
        userInfo.setSessionKey(sessionKey);
        HttpResult<VisitUserInfo> httpResult = new HttpResult<>();
        if (visitUserInfoService.add(userInfo) < 0) {
            httpResult.setMsg("添加失败！");
            httpResult.setSuccess(false);
            return httpResult;
        }
        httpResult.setResult(userInfo);
        return httpResult;
    }


    private void saveImageInfo(String fileName,byte[] fileBytes,String userInfoId,String result) {
        ThreadPoolUtils.run(() -> {
            String url = QiniuUtil.getImgUrl(QiniuUtil.uploadImg(fileName,fileBytes));
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            uploadImageInfo.setUserInfoId(userInfoId);
            uploadImageInfo.setUrl(url);
            uploadImageInfo.setCreateDate(new Date());
            uploadImageInfo.setResult(result);
            uploadImageInfoService.add(uploadImageInfo);
        });
    }

    private void saveImageInfo(String imageUrl,String userInfoId,String result) {
        ThreadPoolUtils.run(() -> {
            UploadImageInfo uploadImageInfo = new UploadImageInfo();
            uploadImageInfo.setUserInfoId(userInfoId);
            uploadImageInfo.setUrl(imageUrl);
            uploadImageInfo.setCreateDate(new Date());
            uploadImageInfo.setResult(result);
            uploadImageInfoService.add(uploadImageInfo);
        });
    }

}
