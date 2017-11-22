package com.ouyang.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * Package: com.ouyang.util
 *
 * @Author: Ouyang
 * @Date: 2017/11/22
 */
public class BaiduAiUtil {

    private static final String APP_ID = "10420833";
    private static final String API_KEY = "cDkXygo1c02AbChObdG29Mlx";
    private static final String SECRET_KEY = "Lim8y6TL7ICT9KgGRFG4F1mVCjIotQDV";
    private static final AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    /**
     * 人脸识别
     */
    public static JSONObject faceRecognize(byte[] file) {
        // 自定义参数定义
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty,qualities");

        // 参数为本地图片路径
//        String imagePath = "face.jpg";
//        JSONObject response = client.detect(imagePath, options);
//        System.out.println(response.toString());

        // 参数为本地图片文件二进制数组
        return client.detect(file, options);
    }
}
