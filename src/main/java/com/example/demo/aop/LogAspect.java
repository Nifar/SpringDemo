package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void beforeAdvice(JoinPoint jp) {
        StringBuilder args = new StringBuilder();
        for (Object obj : jp.getArgs()) {
            if (null != obj)
                args.append(obj.getClass() + "  ");
        }
        log.info("beforeAdvice-Method name: {}, input ARGS: {}", jp.getSignature().getName(), args);
    }

    @After(value = "log()")
    public void afterAdvice(JoinPoint jp) {
        log.info("afterAdvice-Method name: {}", jp.getSignature().getName());
    }

    @AfterThrowing(value = "log()", throwing = "e")
    public void throwingAdvice(JoinPoint jp, Throwable e) {
        log.error("throwingAdvice-Method name: {}, method return: {}", jp.getSignature().getName(), e.getMessage());
    }

}
