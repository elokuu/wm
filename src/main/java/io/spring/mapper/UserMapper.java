package io.spring.mapper;

import io.spring.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> getAll();

    void insertUser(User user);

    User getUser(String name);

    void updateUser(String name, String password, String email);
    void updateState(Map map);
    void addUser(User user);
    void updatePassword(Map map);
}
