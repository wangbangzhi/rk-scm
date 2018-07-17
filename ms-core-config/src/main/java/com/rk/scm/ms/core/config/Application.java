/*
 * Document    : Application.java
 * Created on  : 18-7-17 上午9:45
 * Last Update : 18-7-17 上午9:45
 * Author      : wangbz
 */

package com.rk.scm.ms.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
