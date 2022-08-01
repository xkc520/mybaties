package demo;

import mapper.brandmapper;
import mapper.usermapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Brand;
import pojo.user;
import util.sqlsessionfactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class demo {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlsessionfactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }
    }
