package cn.junhaox.micro_city3;

import cn.junhaox.micro_city3.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 11:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MicroCity3ApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void test() {
        CityService cityService = (CityService) context.getBean("cityService");
        System.out.println(cityService.getCityDao());
    }

}
