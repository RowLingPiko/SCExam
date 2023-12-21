package cn.voidtech.registerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 注册中心服务端
 * @author RowLingKaslana
 */
@SpringBootApplication
@EnableEurekaServer // 开启Eureka服务
public class RegisterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterServerApplication.class, args);
    }

}
