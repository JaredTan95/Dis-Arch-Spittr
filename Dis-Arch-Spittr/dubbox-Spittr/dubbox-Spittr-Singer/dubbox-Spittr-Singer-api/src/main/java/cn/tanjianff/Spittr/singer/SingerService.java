package cn.tanjianff.Spittr.singer;

import cn.tanjianff.Spittr.singer.domain.Singer;

import java.util.List;

/**
 * Created by tanjian on 2017/5/10.
 */
public interface SingerService {
    List<Singer> getSingers();

    Singer save(Singer singer);

    Singer getById(String id);

    List<Singer> getByName(String name);
}
