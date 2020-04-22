```shell script
按照maven的多环境打包,加载不同配置文件

mvn -U clean package -Dmaven.test.skip=true -DskipTests=true -P$PACKAGE_LABEL

多一种实现方式

```
