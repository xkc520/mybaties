package mapper;

import pojo.Brand;

import java.util.List;

public interface brandmapper {
    List<Brand> selectAll();
    void add(Brand brand);
    Brand selectByid(Integer id);
   void update(Brand brand);
   void delete(Brand brand);
}
