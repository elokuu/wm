package io.spring.mapper;

import io.spring.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    void insertUser(User user);
}
