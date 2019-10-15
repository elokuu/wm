package io.spring.mapper;

import io.spring.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> getAll();

    void insertUser(User user);

    User getUser(String name);

    void updateUser(String name, String password, String email);

    int getAllTaskNum(int id_user);

    int getAllGoodNum(int id_user);

    int getAllReviewNum(int id_user);

    int getFavorGoodNum(int id_user);

    List<FavorGoods> getFavorGoods(int id_user);

    List<MyTask> getMyTask(int id_user);

    List<MyGood> getMyGood(int id_user);

    List<MyReview> getMyReview(int id_user);
    void updateState(Map map);
    void addUser(User user);
    void updatePassword(Map map);
}
