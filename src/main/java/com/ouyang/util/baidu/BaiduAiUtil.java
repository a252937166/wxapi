package com.ouyang.util.baidu;

import com.alibaba.druid.support.json.JSONUtils;
import com.baidu.aip.face.AipFace;
import com.ouyang.util.Http;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Package: com.ouyang.util
 *
 * @Author: Ouyang
 * @Date: 2017/11/22
 */
public class BaiduAiUtil {

    private static final String APP_ID = "10429237";
    private static final String API_KEY = "xX4xf1A3lW0eXbQSG3xRiQjt";
    private static final String SECRET_KEY = "aIUKu9eKMCjE1irGTb2ljKKgFfhM4ZLM";
    private static final AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    private static final String accessToken = AuthService.getAuth();
    /**
     * 人脸识别
     */
    public static String faceRecognize(byte[] image) {
        // 自定义参数定义
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty,qualities");

        // 参数为本地图片路径
//        String imagePath = "face.jpg";
//        JSONObject response = client.detect(imagePath, options);
//        System.out.println(response.toString());

        // 参数为本地图片文件二进制数组
        return client.detect(Base64Util.encode(image),"BASE64", options).toString();
    }

    /**
     * 菜品识别
     * @return
     */
    public static String dish(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
        return getImageResult(image,url);
    }

    /**
     * 车辆识别
     * @return
     */
    public static String car(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car";
        return getImageResult(image,url);
    }

    /**
     * 植物识别
     * @return
     */
    public static String plant(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/plant";
        return getImageResult(image,url);
    }


    /**
     * 动物识别
     * @return
     */
    public static String animal(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        return getImageResult(image,url);
    }


    public static String logo(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/logo";
        return getImageResult(image,url);
    }

    /**
     * ORC通用
     * @param image
     * @return
     */
    public static String orcGeneralBasic(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        return getImageResult(image,url);
    }

    /**
     *
     * @param image
     * @return
     */
    public static String orcBankcard(byte[] image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard";
        return getImageResult(image,url);
    }


    private static String getImageResult(byte[] file,String url) {
        try {
            String imgStr = Base64Util.encode(file);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getImageResult(byte[] file,String url,String params) {
        try {
            String imgStr = Base64Util.encode(file);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&" + params;
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getImageResult(String imageUrl,String url) {
        try {
            String param = "url=" + imageUrl;
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getImageResult(String imageUrl,String url,String params) {
        try {
            String param = "url=" + imageUrl + "&" + params;;
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_field", "age,beauty,qualities");

        String jsonObject = client.detect("https://qiniu.ouyanglol.com/31aabe97223843d09de7d3c6829da556_tmp_2df77d0a25b1b41418f1470c4bb0c731.jpg","URL", options).toString();
        System.out.println(jsonObject);
        try {
            JSONObject faceJson = new JSONObject(jsonObject);
            JSONArray resultArray = (JSONArray) ((JSONObject) faceJson.get("result")).get("face_list");
            JSONObject jsonResult = (JSONObject) resultArray.get(0);
            String resultStr = jsonResult.toString();
            System.out.println(resultStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
