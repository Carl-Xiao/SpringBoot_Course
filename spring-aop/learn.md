## 使用Aop需要记住几点
> 执行同一个拦截器的顺序 around->before->执行逻辑(joinPoint.proceed())->around->AfterReturning/(AfterThrowing)
> 多个拦截器拦截同一个方法用@Order(value=0-int上限数值)指定拦截器的先后顺序确保业务可控

### 简单使用
> 使用around即可
```java
   @Pointcut("execution(public * com.xiao.controller..*.*(..)) && @annotation(AopMethod)  ")
    public void webLog() {
    }
    @Around(value = "webLog()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        String result = (String) joinPoint.proceed();
        return result + "===============================A";
    }
```
### 复杂使用 

> 搞清楚Aop前后执行顺序即可,复杂事情简单化。每一个切面保持单一职责处理逻辑


## @Import使用

> 这个功能用得不多但是比较有用。功能是将一个普通类放进Spring容器管理

[参考文档](https://blog.51cto.com/4247649/2118354)

```
curl http://localhost:8080/sayPython 
查看打印结果
```







