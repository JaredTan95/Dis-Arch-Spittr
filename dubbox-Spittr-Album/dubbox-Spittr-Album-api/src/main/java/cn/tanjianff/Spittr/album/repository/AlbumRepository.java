package cn.tanjianff.Spittr.album.repository;

import cn.tanjianff.Spittr.album.domain.Album;

import java.util.List;

/**
 * Created by tanjian on 2017/5/3.
 * 专辑实体存储接口
 */
public interface AlbumRepository {
    boolean save(Album song);

    int count();

    int updateOne(Album album);

    Album findById(String id);

    List<Album> findBySingerId(String id);

    List<Album> orderByPubTime();

    List<Album> findAll();

    List<Album> ListByVis();

    List<Album> findByTitle(String title);

    List<Album> findByVisited(int lmt);

}
