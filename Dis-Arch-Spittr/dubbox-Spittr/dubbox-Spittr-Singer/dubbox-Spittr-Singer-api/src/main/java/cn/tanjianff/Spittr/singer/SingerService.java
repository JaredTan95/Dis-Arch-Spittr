package cn.tanjianff.Spittr.singer;

import cn.tanjianff.Spittr.singer.domain.Singer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanjian on 2017/5/10.
 * 歌手服务接口
 */
public interface SingerService extends Serializable{
    List<Singer> getSingers();

    Singer save(Singer singer);

    Singer getById(String id);

    List<Singer> getByName(String name);
}
