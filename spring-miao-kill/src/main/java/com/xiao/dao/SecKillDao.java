package com.xiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SecKillDao {
    @Select("select version from xiao_store where id=1")
    String getVersion();

    @Update("update xiao_store set store=store-1,version=version+1 where store>0 and version=#{0}")
    int updateStore(int version);

    @Update("update xiao_store set store=store-1,version=version+1 where store>0 ")
    int updateStore();
}
