package web;

import mapper.usermapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.user;
import service.userservice;
import util.sqlsessionfactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    service.userservice userservice= new userservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户数据
        String username = request.getParameter("username");
      String  password = request.getParameter("password");

        //封装用户对象
        user user = new user();
       user.setUsername(username);
       user.setPassword(Integer.valueOf(password));

        boolean flag = userservice.add(user);


/*

        //2. 调用mapper 根据用户名查询用户对象
        //2.1 获取SqlSessionFactory对象
   String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
       // SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 获取SqlSession对象
       // SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 获取Mapper
       // UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //2.4 调用方法
      //  User u = userMapper.selectByUsername(username);


        //3. 判断用户对象释放为null
        if( flag){
            // 用户名不存在，添加用户
request.setAttribute("register","注册成功，请登录");
request.getRequestDispatcher("/login.jsp").forward(request,response);
            // 提交事务
            // 释放资源



        }else {
            // 用户名存在，给出提示信息
            request.setAttribute("register","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}