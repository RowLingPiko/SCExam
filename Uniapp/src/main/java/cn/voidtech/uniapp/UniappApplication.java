package cn.voidtech.uniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Uniapp服务端启动类
 * @author 20170
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
@EnableFeignClients // 开启Feign客户端
public class UniappApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniappApplication.class, args);
    }

}
