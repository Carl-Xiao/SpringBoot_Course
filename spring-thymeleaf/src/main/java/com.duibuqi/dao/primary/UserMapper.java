package com.duibuqi.dao.primary;

import com.duibuqi.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<User> getAllUser();

    @Select("select * from users where id=#{id}")
    User getUserById(Integer id);

    @Delete("delete from users where id=#{id}")
    int delUserById(Integer id);

    @Update("update users set gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where name=#{name}")
    int UpdateUser(User user);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into users(name,gender,age,address,qq,email) values (#{name},#{gender},#{age},#{address},#{qq},#{email})")
    int InsertUser(User user);

}