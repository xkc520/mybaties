package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.user;

public interface usermapper
{
    void  delete(user u);
    user selectByname(String  username);
    void  add(user u);
    user select(@Param("username") String username,@Param("password") Integer password);
}
