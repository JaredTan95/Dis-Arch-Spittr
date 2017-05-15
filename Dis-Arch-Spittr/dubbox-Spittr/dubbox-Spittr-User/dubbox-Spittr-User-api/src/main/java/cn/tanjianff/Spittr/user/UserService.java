package cn.tanjianff.Spittr.user;

import cn.tanjianff.Spittr.user.domain.User;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface UserService {

    List<User> getUsers();

    User save(User user);

    User getById(String id);

    int getMax();

    User getByAccount(String account);

    List<User> getByNickName(String nickname);

    boolean update(User user);
}
