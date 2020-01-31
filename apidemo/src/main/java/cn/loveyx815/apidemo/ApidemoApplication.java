package cn.loveyx815.apidemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.loveyx815.apidemo.dao"})
public class ApidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApidemoApplication.class, args);
    }

}
