package io.spring.mapper;

import io.spring.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    void insertUser(User user);

    User getUser(String name);

    void updateUser(String name, String password, String email);
}
