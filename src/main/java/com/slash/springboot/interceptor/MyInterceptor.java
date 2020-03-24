package com.slash.springboot.interceptor;


import com.slash.springboot.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class MyInterceptor {
    @Pointcut("within (com.slash.springboot.controller..*) && !within(com.slash.springboot.controller.LoginController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        User user = (User) attribute.getRequest().getSession().getAttribute("user");
        if (user == null) {
            System.out.println("-----------用户未登录-----------");
            attribute.getResponse().sendRedirect("/login");
        }else {
            System.out.println("-----------用户已登录-----------");
        }

        return joinPoint.proceed();
    }

}
