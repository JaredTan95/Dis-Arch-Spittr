package cn.tanjianff.Spittr.user.repository;

import cn.tanjianff.Spittr.user.domain.User;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 * 用户实体操作接口
 */
public interface UserRepository {
    int count();

    boolean save(User user);

    User findById(String id);

    User findByAccount(String account);

    List<User> findByNickName(String nickname);

    boolean update(User user);

    List<User> findAll();

    User isExists(String name,String pwd);
}
