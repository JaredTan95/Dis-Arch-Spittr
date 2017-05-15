package cn.tanjianff.Spittr.album;

import cn.tanjianff.Spittr.album.domain.Album;

import java.util.List;

/**
 * Created by tanjian on 2017/5/3.
 */
public interface AlbumService {

    List<Album> getAlbums();

    Album save(Album album);
    Album getById(String id);
    List<Album> getBySingerID(String id);
    List<Album> getByTitle(String id);

    int getMax();
}
