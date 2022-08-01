package service;

import mapper.usermapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.user;
import util.sqlsessionfactory;

public class userservice {
    SqlSessionFactory sqlSessionFactory = sqlsessionfactory.getSqlSessionFactory();
    public user login(String username, Integer password){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        usermapper usermapper = sqlSession.getMapper(usermapper.class);
        user user = usermapper.select(username, password);
        sqlSession.close();
        return user;
    }
    public user selectByname(String name){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        user user = mapper.selectByname(name);
        sqlSession.close();
        return user;
    }
    public boolean add(user user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        pojo.user user1 = mapper.selectByname(user.getUsername());
        if (user1==null){
            mapper.add(user);
            sqlSession.commit();

        }
        sqlSession.close();
     return user==null;
    }
}
