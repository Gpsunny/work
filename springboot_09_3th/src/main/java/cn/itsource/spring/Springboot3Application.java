package cn.itsource.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.itsource.spring.mapper")// 扫描mapper接口和映射文件
public class Springboot3Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot3Application.class,args);
    }
}
