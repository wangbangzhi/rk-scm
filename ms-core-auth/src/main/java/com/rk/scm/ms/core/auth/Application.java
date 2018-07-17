/*
 * Document    : Application.java
 * Created on  : 18-7-17 上午11:24
 * Last Update : 18-7-17 上午11:24
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
