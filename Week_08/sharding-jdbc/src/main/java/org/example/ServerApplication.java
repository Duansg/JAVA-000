package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ServerApplication
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 下午9:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.*.dao"})
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }
}
