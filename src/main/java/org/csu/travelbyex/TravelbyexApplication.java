package org.csu.travelbyex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.travelbyex.persistence")
public class TravelbyexApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelbyexApplication.class, args);
    }
}
