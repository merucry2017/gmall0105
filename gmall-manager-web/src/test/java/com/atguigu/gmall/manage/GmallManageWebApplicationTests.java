package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        String path = GmallManageWebApplicationTests.class.
                getResource("/tracker.conf").getPath();
        ClientGlobal.init(path);

        TrackerClient trackerClient = new TrackerClient();

        TrackerServer trackerServer = trackerClient.getConnection();
        //通过tracker获得storage客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);

        String[] uploadInfo = storageClient.upload_file("d:/a.jpg","jpg",null);
        for(String info:uploadInfo){
            System.out.println(info);
        }
    }
}
