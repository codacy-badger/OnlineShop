package ro.msg.learning.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@SpringBootApplication
@PropertySource(value = "classpath:application.yaml")
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ShopApplication.class);
        app.run();
    }
}
