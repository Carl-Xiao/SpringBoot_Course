package com.xiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SecKillDao {
    @Select("select version from xiao_store where id=1")
    String getVersion();

    /**
     * 乐观锁
     * @param version 版本号
     * @return 值
     */
    @Update("update xiao_store set store=store-1,version=version+1 where store>0 and version=#{0}")
    int updateStoreByVersion(int version);

    @Update("update xiao_store set store=store-1,version=version+1 where store>0 ")
    int updateStore();
}
