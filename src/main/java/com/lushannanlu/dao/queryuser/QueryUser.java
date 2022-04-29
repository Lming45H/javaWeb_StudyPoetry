package com.lushannanlu.dao.queryuser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.lushannanlu.pojo.User;

public interface QueryUser {
    //通过邮箱查找用户
    @Select("select * from user where email = #{email}")
    User queryUser(@Param("email") String email);
}
