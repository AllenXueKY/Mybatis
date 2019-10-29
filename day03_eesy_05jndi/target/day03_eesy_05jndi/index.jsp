<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.allen.dao.IUserDao" %>
<%@ page import="com.allen.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1.读取配置文件（1.使用类加载器，它只能读取类路径的配置文件  2.使用ServiceContext对象的getRealPath()）
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
    //2.创建SqlSessionFactory工厂(创建工厂，mybatis使用了构建者模式)
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);//builder就是构建者
    //3.使用工厂生产SqlSession对象
    SqlSession sqlSession = factory.openSession();//生产SqlSession使用了工厂模式
    //4.使用SqlSession创建Dao接口的代理对象
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    //5.使用代理对象执行方法
    List<User> users= userDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }
    //6.释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
