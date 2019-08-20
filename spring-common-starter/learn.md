# 定义一个自己的starter

> 众所周知SpringBoot的优势就是在于各种starter，学会如何定义自己合适的starter是非常重要而且高效，但在此之前需要学习Spring的一些注解。

- @Configuration
> 将当前Class设置为bean,放到Spring容器

- @ConditionalOnBean
> 当前类额外需要的Spring工厂中的Bean,至少存在一个

- @EnableConfigurationProperties
> 加载当前配置文件

...
> 所谓存在即合理,各种注解都是有价值的，需要就看看源码说明就行。

[SpringBoot自动加载参考解释](https://cloud.tencent.com/developer/article/1432121)

**至于其他的用法在下了解不多,就不过多说明**


# 使用
- 本地调试
```bash
mvn clean install 本地安装仓库中,引用可以参考spring-multi-enviorment
```
- 发布私服
> 参考deploy_own_jar配置文件与说明

# 结尾

- 这个starter是基于redission,也是我工作中经常使用的一个redis操作工具
- 注意codec指定编码格式,默认JsonJacksonCodec,存的数据可能没办法看，使用的时候自己根据实际需求指定编码格式比较好[https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95](https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95)

