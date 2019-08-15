package com.xiao.annontion;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Carl-Xiao 2019-08-15
 */
@Aspect
@Component
public class LogAopAroundMethod {
    private final static Logger logger = LoggerFactory.getLogger(LogAopAroundMethod.class);

    @Pointcut("execution(public * com.xiao.controller..*.*(..)) && @annotation(AopMethod)  ")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void before(JoinPoint joinPoint) {
        logger.info("handle newsOne");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("Request Method : " + joinPoint.getSignature().getDeclaringTypeName() + "_____" + joinPoint.getSignature().getName());
        List<String> parameterList = new ArrayList<>();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            parameterList.add(paraName + ": " + request.getParameter(paraName));
        }
        logger.info("Request Parameters : " + JSON.toJSONString(parameterList));
    }

    @Around(value = "webLog()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        String result = (String) joinPoint.proceed();
        return result + "===============================A";
    }

    @After(value = "webLog()")
    public void after() throws Throwable {
        logger.info("method over");
    }

    @AfterReturning(value = "webLog()", returning = "retval")
    public void afterReturn(Object retval) throws Throwable {
        logger.info("afterReturning");
        logger.info(retval.toString());
    }

}
