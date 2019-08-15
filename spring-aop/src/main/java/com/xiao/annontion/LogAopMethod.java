package com.xiao.annontion;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Carl-Xiao 2019-08-15
 */
@Aspect
@Component
public class LogAopMethod {
    private final static Logger logger = LoggerFactory.getLogger(LogAopMethod.class);

    @Pointcut("execution(public * com.xiao.controller..*.*(..)) && @annotation(AopMethod)  ")
    public void webLog(){}

//    @Before(value = "webLog()")
//    public void before(JoinPoint joinPoint){
//        logger.info("handle newsOne");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        logger.info("Request Method : " + joinPoint.getSignature().getDeclaringTypeName() + "_____" + joinPoint.getSignature().getName());
//        List<String> parameterList = new ArrayList<>();
//        Enumeration<String> enu=request.getParameterNames();
//        while(enu.hasMoreElements()){
//            String paraName = enu.nextElement();
//            parameterList.add(paraName+": "+request.getParameter(paraName));
//        }
//        logger.info("Request Parameters : " + JSON.toJSONString(parameterList));
//    }



}
