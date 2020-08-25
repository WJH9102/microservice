package cn.junhaox.micro_httpclient;

import cn.junhaox.micro_httpclient.service.HttpClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author WJH
 * @Description
 * @date 2020/8/25 15:32
 * @Email ibytecode2020@gmail.com
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MicroHttpclientApplicationTest {
    @Autowired
    HttpClientService httpClientService;
    @Test
    public void test1() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("wd", "zhangsan");
        System.out.println(httpClientService.doGet("https://www.baidu.com"));
        System.out.println(httpClientService.doPost("https://www.baidu.com"));
        System.out.println(httpClientService.doGet("https://www.baidu.com", map));
        System.out.println(httpClientService.doPost("https://www.baidu.com", map));
    }

    @Test
    public void test2() throws Exception {
        // dc=15&da=15688682388&sm=D5E2CAC7D2BBCCF577656273657276696365BDD3BFDAB2E2CAD4B6CCD0C5A3ACB2E2CAD4B7A2CBCDA3ACB2E2CAD4B7A2CBCDB9FEB9FEB9FE&spid=TEM111&priority=1&command=MT_REQUEST&svrtype=M00000&sppassword=123456
        Map<String, Object> map = new HashMap<>();
        map.put("dc", "15");
        map.put("da", "15688682388");
        map.put("sm", "D5E2CAC7D2BBCCF577656273657276696365BDD3BFDAB2E2CAD4B6CCD0C5A3ACB2E2CAD4B7A2CBCDA3ACB2E2CAD4B7A2CBCDB9FEB9FEB9FE");
        map.put("spid", "TEM111");
        map.put("dcpriority", "1");
        map.put("command", "MT_REQUEST");
        map.put("svrtype", "M00000");
        map.put("sppassword", "123456");
        System.out.println(httpClientService.doPost("http://192.169.1.33:8082/sms/mt", map));
    }
}
