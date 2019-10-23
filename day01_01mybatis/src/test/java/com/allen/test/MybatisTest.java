package com.allen.test;

import com.allen.dao.IUserDao;
import com.allen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件（1.使用类加载器，它只能读取类路径的配置文件  2.使用ServiceContext对象的getRealPath()）
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂(创建工厂，mybatis使用了构建者模式)
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//builder就是构建者
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();//生产SqlSession使用了工厂模式
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users= userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
