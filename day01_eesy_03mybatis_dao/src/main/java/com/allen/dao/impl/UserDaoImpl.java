package com.allen.dao.impl;

import com.allen.dao.IUserDao;
import com.allen.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll(){
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> users = session.selectList("com.allen.dao.IUserDao.findAll");
        //3.返回查询结果
        return users;
    }
}
