package com.kingjakeu.springstudy.common.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class S3UploaderTest {
    @Autowired
    private S3Uploader s3Uploader;

    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream(new File("src/test/java/com/kingjakeu/springstudy/common/util/agumon.jpeg"));
        MultipartFile multipartFile = new MockMultipartFile("agumon", "agumon","image/jpeg", fis);
        s3Uploader.postFile("", "agumon", multipartFile);
    }
}
