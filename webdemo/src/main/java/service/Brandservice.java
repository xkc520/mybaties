package service;

import mapper.brandmapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import util.sqlsessionfactory;

import java.util.List;

public class Brandservice {
       SqlSessionFactory sqlSessionFactory = sqlsessionfactory.getSqlSessionFactory();

    public List<Brand> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        brandmapper brandmapper = sqlSession.getMapper(brandmapper.class);
        List<Brand> brands = brandmapper.selectAll();
        sqlSession.close();
        return brands;
    }
    public void add(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.add(brand);
        System.out.println(brand);

        sqlSession.close();
    }
    public Brand selectByid(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        Brand brand = mapper.selectByid(id);
        sqlSession.close();
        return brand;
    }
    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
      mapper.update(brand);
        System.out.println(brand);
        sqlSession.close();
    }
    public void delete(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
      mapper.delete(brand);
        sqlSession.close();
    }
}
