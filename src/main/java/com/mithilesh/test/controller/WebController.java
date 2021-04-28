package com.mithilesh.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebController {

//    @Value("${application.name}")
    private String appName = "TestApp";

    @GetMapping("/test")
    public String getAppName() {
        log.info(appName);
        return "App Name: " + appName;
    }

}
