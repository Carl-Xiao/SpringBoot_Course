# 了解乐观锁和悲观锁

## 乐观锁

### version
> 利用 set version = newVersion where version = oldVersion （CAS机制）

### 理解CAS机制
> compare and swap 比较并且交换两个数 
- 多个线程同时操作的时候,最终只有一个线程能够更新当前的数据



### 解决方案
- 令牌算法+MQ异步处理数据(操作数据库)


