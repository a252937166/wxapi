package com.ouyang.util;

import com.ouyang.util.baidu.HttpUtil;
import com.youtu.Youtu;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Package: com.ouyang.util
 *
 * @Author: Ouyang
 * @Date: 2017/11/22
 */
public class TencentAiUtil {
    private static final String APP_ID = "10108902";
    private static final String SECRET_ID = "AKID1rRmsinhrpZAXkSKm11nKcgV5QXPQRbb";
    private static final String SECRET_KEY = "qTsypRowoRpxpd1E6iLlyvc3E9nBJAl6";
    private static final String USER_ID = "250757958";
    private static Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);

    public static String detectFace(String imageUrl) throws KeyManagementException, NoSuchAlgorithmException, JSONException, IOException {
        //人脸检测调用示例
        return faceYoutu.DetectFaceUrl(imageUrl,0);
    }

    public static void main(String[] args) {
        try {

            String s = HttpUtil.getUrl("https://api.weixin.qq.com/sns/jscode2session?appid=wxeadff8cfd42bc3a9&secret=08cb141033ff61196cddb284fac405a7&js_code=003ifqN406osTI1QoTK40lkpN40ifqNA&grant_type=authorization_code","application/json","UTF-8");
            JSONObject j = new JSONObject(s);
            String id = (String) j.get("openid");
            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
