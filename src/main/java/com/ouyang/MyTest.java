package com.ouyang;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
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
    @Test
    public void test() throws IOException {
        HttpURLConnection urlcon = null;
        URL url = new URL("http://img.bizhi.sogou.com/images/2012/03/14/124196.jpg");
        //open url
        urlcon = (HttpURLConnection)url.openConnection();
        //get url properties
        long fileSize=urlcon.getContentLengthLong();
        InputStream inputStream = url.openStream();
        System.out.println(fileSize);
        StorePath storePath = storageClient.uploadFile(inputStream,fileSize,"",null);
        System.out.println(storePath.getFullPath());
    }
}
