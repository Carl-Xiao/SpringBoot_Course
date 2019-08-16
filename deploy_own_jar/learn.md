### maven私服

> 私服是一个绕不开内容,公司项目私有jar,工具jar等。学会熟练使用jar以及更新jar

### docker安装(centos)
```
yum -y install docker
systemctl start docker
docker pull sonatype/nexus3
docker images 查看nexus3的镜像ID

docker run -d --name=nexus3 --restart=always -p 8082:8081 镜像ID

进入bash操作界面查看初始密码
docker exec -it 7093e3093a04 /bin/bash

cat /nexus-data/admin.password 查看初始化密码

访问地址 http://端口:8082/
登录帐号admin
密码 初始化密码

```
### maven私库 release

- 修改maven本地setting配置
```
	<server>
      <id>xiao-release</id>
      <username>xiao</username>
      <password>cd123456</password>
    </server>
    
```

- 修改pom配置
```
  <distributionManagement>
        <repository>
            <id>xiao-release</id>
            <name>nexus Maven 2 Repository</name>
            <url>${nexus.url}</url>
        </repository>
  </distributionManagement>
```

> 父Pom已经实现,子项目参考deploy_own_jar_imp



