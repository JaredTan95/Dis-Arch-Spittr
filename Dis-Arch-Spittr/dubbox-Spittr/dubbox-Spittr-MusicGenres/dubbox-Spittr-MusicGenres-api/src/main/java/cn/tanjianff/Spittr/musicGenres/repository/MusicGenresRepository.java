package cn.tanjianff.Spittr.musicGenres.repository;

import cn.tanjianff.Spittr.musicGenres.domain.MusicGenre;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 */
public interface MusicGenresRepository {
    boolean save(MusicGenre musicGenre);

    List<MusicGenre> findBySongId(String id);

    List getByAlbumId(String id);

    int count();
}
