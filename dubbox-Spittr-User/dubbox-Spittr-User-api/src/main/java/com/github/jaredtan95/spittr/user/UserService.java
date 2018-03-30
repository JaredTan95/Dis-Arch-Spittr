package com.github.jaredtan95.spittr.user;

import com.github.jaredtan95.spittr.user.domain.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User save(User user);

    public User getById(String id);

    public int getMax();

    public User getByAccount(String account);

    public List<User> getByNickName(String nickname);

    public boolean update(User user);

    public User loginVali(String name, String pwd);
}
