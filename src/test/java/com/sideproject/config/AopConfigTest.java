package com.sideproject.config;

import com.sideproject.controller.IsLikedApiController;
import com.sideproject.repository.IsLikedRepository;
import com.sideproject.service.IsLikedService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
@SpringBootTest
public class AopConfigTest {
    @Autowired
    IsLikedApiController isLikedApiController;
    @Autowired
    IsLikedService isLikedService;
    @Autowired
    IsLikedRepository isLikedRepository;

    @Test
    void aopInfo() {
        log.info("isLikedApiController:{}",isLikedApiController);
        log.info("isAopProxy, isLikedService={}", AopUtils.isAopProxy(isLikedService));
        log.info("isAopProxy, isLikedRepository={}", AopUtils.isAopProxy(isLikedRepository));
    }

}
