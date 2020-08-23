package cn.junhaox.micro_city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 11:09
 */
@SpringBootApplication
@MapperScan(value = "cn.junhaox.micro_city.mapper")
public class MicroCityApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCityApplication.class, args);
    }
}
