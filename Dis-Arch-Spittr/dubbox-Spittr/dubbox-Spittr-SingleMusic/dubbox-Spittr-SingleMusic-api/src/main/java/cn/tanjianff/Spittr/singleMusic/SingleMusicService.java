package cn.tanjianff.Spittr.singleMusic;

import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface SingleMusicService extends Serializable{

    List<SingleMusic> getSongs();

    SingleMusic save(SingleMusic song);
    SingleMusic getById(String id);
    List<SingleMusic> getBySingerID(String id);
    List<SingleMusic> getByTitle(String title);
    List<SingleMusic> getByVisited();
    List<SingleMusic> getByDloaded();
    List<SingleMusic> getByUpDate();
    int getMax();
}
