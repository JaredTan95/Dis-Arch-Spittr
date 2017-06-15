package cn.tanjianff.Spittr.singleMusic.repository;

import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface SingleMusicRepository {
    boolean save(SingleMusic song);

    int count();

    SingleMusic findById(String id);

    List<SingleMusic> findBySingerId(String id);

    List<SingleMusic> findAll();

    List<SingleMusic> findByTitle(String title);

    List<SingleMusic> OrderByVisited();

    List<SingleMusic> OrderByDloaded();

    List<SingleMusic> OrderByUpDate();

    boolean IncrVisit(String songId);
}
