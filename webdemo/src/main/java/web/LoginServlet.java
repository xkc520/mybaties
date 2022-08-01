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
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    userservice demo=new userservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //2. 调用MyBatis完成查询
        //2.1 获取SqlSessionFactory对象
       /* String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

       /* SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4 调用方法
        User user = userMapper.select(username, password);
        //2.5 释放资源*/
        user user = demo.login(username, Integer.valueOf(password));
        //3. 判断user释放为null
        if(user != null){
            // 登陆成功
            if ("1".equals(remember)) {
                Cookie c_username=new Cookie("c_username",username);
                Cookie c_password=new Cookie("c_password",password);
                c_password.setMaxAge(60*60*24);
                c_username.setMaxAge(60*60*24);
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            HttpSession session = request.getSession();
        session.setAttribute("user",user);
            response.sendRedirect("/web/selectAllServlet");
        }else {
            request.setAttribute("login","用户名或者密码错误");
            // 登陆失败
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}