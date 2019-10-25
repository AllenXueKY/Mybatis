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

    public List<User> findAll() {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询列表
       List<User> users = session.selectList("com.allen.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3、释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现保存
        session.insert("com.allen.dao.IUserDao.saveUser",user);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    public void updateUser(User user) {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现更新
        session.update("com.allen.dao.IUserDao.updateUser",user);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    public void deleteUser(Integer userId) {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现删除
        session.delete("com.allen.dao.IUserDao.deleteUser",userId);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    public User findById(Integer userId) {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询列表
        User user = session.selectOne("com.allen.dao.IUserDao.findById",userId);//参数就是能获取配置信息的key
        //3、释放资源
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.allen.dao.IUserDao.findByName",username);//参数就是能获取配置信息的key
        //3、释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1、根据factory获取SQLSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询列表
        Integer count = session.selectOne("com.allen.dao.IUserDao.findTotal");//参数就是能获取配置信息的key
        //3、释放资源
        session.close();
        return count;
    }
}
