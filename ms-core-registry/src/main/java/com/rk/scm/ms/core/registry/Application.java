/*
 * Document    : Application.java
 * Created on  : 18-7-17 上午9:36
 * Last Update : 18-7-17 上午9:36
 * Author      : wangbz
 */

package com.rk.scm.ms.core.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
