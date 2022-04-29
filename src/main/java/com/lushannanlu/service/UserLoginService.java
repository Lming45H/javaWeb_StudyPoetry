package com.lushannanlu.service;

import com.lushannanlu.dao.queryuser.QueryUser;
import com.lushannanlu.msg.Message;
import org.apache.ibatis.session.SqlSession;
import com.lushannanlu.pojo.User;
import com.lushannanlu.utils.MybatisUtil;

public class UserLoginService {
    private Message message=null;

    //处理用户登录
    public Message isAccessLogin(String email,String password){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        QueryUser mapper = sqlSession.getMapper(QueryUser.class);
        User user = mapper.queryUser(email);
        if(user==null){
            message = new Message(0,"用户不存在");
        }else if(!password.equals(user.getPassword())){
           message = new Message(1,"密码不正确");
        }else {
            message = new Message(2,"登录成功");
        }
        return message;
    }
}
