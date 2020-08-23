package cn.junhaox.micro_city3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 11:09
 */
@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
public class MicroCity3Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroCity3Application.class, args);
    }
}
