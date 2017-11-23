package com.ouyang.util;

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
            String j = detectFace("https://qiniu.ouyanglol.com/ba8e95719510443dbaf1d87aba763cb7_wxdf95e58238bdb05a.o6zAJs9W_uJeJo7vcvGsIWe-0jwg.afee67a619f2f862790c52e9aed5b985.jpg");
            System.out.println(j);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
