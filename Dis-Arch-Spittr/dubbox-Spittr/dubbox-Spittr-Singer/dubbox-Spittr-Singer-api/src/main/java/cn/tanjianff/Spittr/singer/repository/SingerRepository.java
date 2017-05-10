package cn.tanjianff.Spittr.singer.repository;

import cn.tanjianff.Spittr.singer.domain.Singer;

import java.util.List;

/**
 * Created by tanjian on 2017/5/10.
 */
public interface SingerRepository {
    int count();

    boolean save(Singer singer);

    Singer findById(String id);

    List<Singer> findByName(String name);

    List<Singer> findAll();
}
