package com.lushannanlu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

        private static SqlSessionFactory sqlSessionFactory;
        static {
            try {
                //使用Mybatis第一步，获取SqlSessionFactory对象
                String resource = "Mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //有了SqlSessionFactory，就可以从中获得SqlSession的实例
        //SqlSession 完全包含了面向数据库执行SQL 命令所需的所有方法
        public static SqlSession getSqlSession() {
            return sqlSessionFactory.openSession();
        }

}
