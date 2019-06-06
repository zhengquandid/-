package com.likzn.lisblog;

import com.likzn.lisblog.service.ArticleInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LisblogApplicationTests {

    @Autowired
    ArticleInfoService articleInfoService;
    @Test
    public void contextLoads() {
//        System.out.println(articleInfoService.count());

    }

}
