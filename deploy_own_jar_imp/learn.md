## 发布release项目

### 第一种发布release
> deploy 发布版本,根据配置文件release/snapshot即可
```bash
 mvn clean deploy
```
- 注意项目version不能带有SNAPSHOT(快照标签)
- 如果需要SNAPSHOT,同理maven私库同样创建SNAPSHOT仓库，配置一样

### 第二种发布release
>

```bash
//预发布
mvn release:prepare

console出现信息
What is the release version for "项目artifactId"? (com.xiao:common-xiao) 1.0: : 1.1  //release的版本是多少
What is SCM release tag or label for "项目artifactId"? (com.xiao:common-xiao) v1.1: : //tag标签
What is the new development version for "项目artifactId"? (com.xiao:common-xiao) 1.2-SNAPSHOT: : // 待发布的版本是多少

//发布版本
mvn release:perform -DuseReleaseProfile=false

//回滚版本
mvn release:rollback
```



