package com.ouyang;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.ouyang.controller.ApiController;
import com.ouyang.model.VisitUserInfo;
import com.ouyang.service.UploadImageInfoService;
import com.ouyang.service.VisitUserInfoService;
import com.ouyang.util.FastDFSClientWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private FastFileStorageClient storageClient;
    @Autowired
    private VisitUserInfoService visitUserInfo;
    @Test
    public void test() throws IOException {
    }
}
