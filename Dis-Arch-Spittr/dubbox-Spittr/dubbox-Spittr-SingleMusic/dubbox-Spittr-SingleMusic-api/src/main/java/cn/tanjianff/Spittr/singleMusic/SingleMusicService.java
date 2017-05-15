package cn.tanjianff.Spittr.singleMusic;

import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface SingleMusicService {

    List<SingleMusic> getSongs();

    SingleMusic save(SingleMusic song);
    SingleMusic getById(String id);
    List<SingleMusic> getBySingerID(String id);
    List<SingleMusic> getByTitle(String title);
    List<SingleMusic> getByVisited();
    List<SingleMusic> getByDloaded();
    int getMax();
}
