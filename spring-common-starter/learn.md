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

